package com.example.android.canny;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends ActionBarActivity {
    private int PICK_IMAGE_REQUEST = 1;
    private int RESULT_LOAD_IMAGE = 1;

    private static int CAMERA_PIC_REQUEST = 1;

    static {
        if(!OpenCVLoader.initDebug()){
            Log.i("opencv","opencv initialization failed");
             }
        else {
            Log.i("opencv","opencv initilization successful");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  /*      Button gallery = (Button)findViewById(R.id.galleryImage);
        gallery.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intentGallery = new Intent(MainActivity.this, CameraImg.class);
                startActivity(intentGallery);

            }
        });   */

        Button camera = (Button)findViewById(R.id.cameraImage);
        camera.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentCamera = new Intent(MainActivity.this,CameraImg.class);
                startActivity(intentCamera);
            }
        });




 /*      Button galleryImg = (Button)findViewById(R.id.galleryImage);
        galleryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });   */
/*        Button cameraImg = (Button)findViewById(R.id.cameraImage);
        cameraImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Intent intent = new Intent();
// Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);


                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });   */

    }



/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.inputImage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }

    }

 /*   @Override
    protected void onActivityResult2(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap thumbnail = null;
        if (requestCode == CAMERA_PIC_REQUEST) {

            if (resultCode == RESULT_OK) {

                thumbnail = (Bitmap) data.getExtras().get("data");

                Intent i = new Intent(this, CameraImg.class);
                i.putExtra("name", thumbnail);
                startActivity(i);



            }

        }

    }   */

 /*   public void galleryLoad()
    {
        Intent intent = new Intent(MainActivity.this,GallaryImg.class);
        startActivity(intent);
    }   */

    public void openCamera()
    {
        Intent intent = new Intent(MainActivity.this,CameraImg.class);
        startActivity(intent);
    }

}
