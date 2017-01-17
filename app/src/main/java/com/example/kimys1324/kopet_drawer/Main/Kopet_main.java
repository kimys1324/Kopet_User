package com.example.kimys1324.kopet_drawer.Main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.kimys1324.kopet_drawer.Common.MLRoundedImageView;
import com.example.kimys1324.kopet_drawer.Common.RoundedImageView;
import com.example.kimys1324.kopet_drawer.Fragment.FindAbandoned.FindAbandonedFragment;
import com.example.kimys1324.kopet_drawer.Fragment.DirectMessage.DirectMessageFragment;
import com.example.kimys1324.kopet_drawer.Fragment.Mypage.MypageFragment;
import com.example.kimys1324.kopet_drawer.Fragment.PetCenter.PetCenterFragmnet;
import com.example.kimys1324.kopet_drawer.R;

public class Kopet_main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int SELECT_PICTURE = 1324;

    private String represent_imagePath;
    private String represent_text;

    private String selectedImagePath;
    private ImageView setProfileBtn;

    private void getUserdata(){}
    private void getPet1data(){}
    private void getPet2data(){}

    private void setReresent()
    {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        this.represent_imagePath = pref.getString("represent_imagePath",null);
        this.represent_text = pref.getString("represent_name",null);

        if( represent_imagePath != null)
        {
            // default image
        }
        else
        {
            //set image
            /*
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            selectedImagePath = represent_imagePath;
            Bitmap myBitmap = BitmapFactory.decodeFile(selectedImagePath, options);
            myBitmap = Bitmap.createScaledBitmap(myBitmap, setProfileBtn.getWidth(), setProfileBtn.getHeight(), true);
            setProfileBtn.setImageBitmap(myBitmap);
            */
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new MypageFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_main, menu);

        setProfileBtn = (ImageView)findViewById(R.id.drawer_represent_imgbtn);
        this.setReresent();
        setProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set represent pet
                setProfileImageAction();


            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.drawer_mypage) {
            //1st : My page
            fragment = new MypageFragment();


        } else if (id == R.id.drawer_search) {
            //2nd : Search abandoned pet
            fragment = new FindAbandonedFragment();

        } else if (id == R.id.drawer_message) {
            //3rd : Direct Message
            fragment = new DirectMessageFragment();

        } else if (id == R.id.drawer_pet_center) {
            //4th : Pet Center
            fragment = new PetCenterFragmnet();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .addToBackStack(null)
                    .commit();
        }

        return true;
    }


    //Set Profile Image Button Action

    private void setProfileImageAction()
    {
        /*
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,
                "Select Picture"), SELECT_PICTURE);
        */
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, SELECT_PICTURE);
    }


        public void onActivityResult(int requestCode, int resultCode, Intent data) {

            if (resultCode == RESULT_OK) {
                if (requestCode == SELECT_PICTURE) {
                    Log.d("gallery:","Data ~ "+data.toString());
                    Uri selectedImageUri = data.getData();
                    Log.d("gallery:","URI ~ "+selectedImageUri.toString());
                    selectedImagePath = getPath2(selectedImageUri);
                    Log.d("gallery:","imagepath ~ "+selectedImagePath.toString());
                    this.savePreferences("represent_imagePath", selectedImagePath);

                    /*
                    Bitmap image_bitmap 	= null;
                    try {
                        image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    */


                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;

                    Bitmap myBitmap = BitmapFactory.decodeFile(selectedImagePath, options);
                    myBitmap = Bitmap.createScaledBitmap(myBitmap, setProfileBtn.getWidth(), setProfileBtn.getHeight(), true);
                    setProfileBtn.setImageBitmap(myBitmap);
                    //setProfileBtn.setImageBitmap(image_bitmap);
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }


    public String getPath(Uri uri) {
        // uri가 null일경우 null반환
        if( uri == null ) {
            Log.d("galleyUri"," is null");
            return null;
        }
        // 미디어스토어에서 유저가 선택한 사진의 URI를 받아온다.
        String[] projection = { MediaStore.Images.Media.DATA };

        CursorLoader cursorLoader = new CursorLoader(this, uri, projection, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();
        if( cursor != null ){
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();

           // Log.d("galleyUri", cursor.getString(column_index));
            return cursor.getString(column_index);
        }
        // URI경로를 반환한다.

        Log.d("galleyUri", uri.getPath());
        return uri.getPath();
    }

    public  String getPath2(Uri selectedImage)
    {
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        return picturePath;
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };

        CursorLoader cursorLoader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    public String getImagePathToUri(Uri data)
    {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);

        return imgPath;
    }

    private void savePreferences(String a, String b){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(a, b);
        editor.commit();
    }
}
