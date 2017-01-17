package com.example.kimys1324.kopet_drawer.Fragment.Mypage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.kimys1324.kopet_drawer.Data.PetData;
import com.example.kimys1324.kopet_drawer.R;


/**
 * Created by kimys1324 on 6/30/16.
 */
public class MypageFragment extends Fragment {

    private static final int SELECT_PICTURE = 2;

    private String selectedImagePath;
    private ImageButton setProfileBtn;

    private ImageButton usrEdit, pet1Edit, pet2Edit;
    private ImageButton reportBtn1, reportBtn2;
    private ImageButton fpBtn1, fpBtn2;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_my_page, container, false);
        Toolbar tb = (Toolbar)rootView.findViewById(R.id.toolbar);



        usrEdit = (ImageButton)rootView.findViewById(R.id.usercard_edit_btn);
        pet1Edit = (ImageButton)rootView.findViewById(R.id.pet1_card_edit_btn);
        pet2Edit = (ImageButton)rootView.findViewById(R.id.pet2_card_edit_btn);

        reportBtn1 = (ImageButton)rootView.findViewById(R.id.pet1_card_report_missing_btn);
        reportBtn2 = (ImageButton)rootView.findViewById(R.id.pet2_card_report_missing_btn);

        fpBtn1 = (ImageButton)rootView.findViewById(R.id.pet1_fingerprint_btn);

        pet1Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new Pet1EditFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        pet2Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new Pet2EditFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        reportBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportMissing("달리");
            }
        });

        reportBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportMissing("진돌이");
            }
        });

        fpBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new FingerprintFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    private void setUserProfile()
    {
        ImageView userImage = (ImageView)getActivity().findViewById(R.id.usercard_image);
    }

    private void setPetProfile()
    {
        ImageView petCardImage = (ImageView)getActivity().findViewById(R.id.pet1_card_image);
    }

    private void setPet2Profile()
    {
        ImageView petCardImage = (ImageView)getActivity().findViewById(R.id.pet2_card_image);
    }

    private void reportMissing(String name)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());

        builder.setMessage(name+"의 실종신고를 진행하시겠습니까?")
                .setCancelable(true)
                .setPositiveButton("확인", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Fragment fragment = new ReportFragment();

                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_content, fragment)
                                .addToBackStack(null)
                                .commit();

                        //확인 눌렀을 때 Action
                    }
                } )
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //취소 눌렀을 때 Action
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setProfileImageAction()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,
                "Select Picture"), SELECT_PICTURE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                Log.d("kimys1324", " imagepath : "+selectedImagePath);
            }
        }
    }

    public String getPath(Uri uri) {
        // uri가 null일경우 null반환
        if( uri == null ) {
            return null;
        }
        // 미디어스토어에서 유저가 선택한 사진의 URI를 받아온다.
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // URI경로를 반환한다.
        return uri.getPath();
    }

    private void setProfileImage(String imagePath)
    {
        SharedPreferences pref = getActivity().getSharedPreferences("pref", getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("imagePath", imagePath);
        editor.commit();
    }

    private String getProfileImage()
    {
        String path;

        SharedPreferences pref = getActivity().getSharedPreferences("pref", getActivity().MODE_PRIVATE);
        path = pref.getString("imagePath",null);

        return path;
    }

    //pet card action


}
