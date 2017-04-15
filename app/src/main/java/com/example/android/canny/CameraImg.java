package com.example.android.canny;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.WindowManager;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;


/**
 * Created by lalli on 28/1/16.
 */
public abstract class CameraImg extends Activity implements CameraBridgeViewBase.CvCameraViewListener2 {
    private CameraBridgeViewBase mOpenCvCameraView;
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i("opencv", "OpenCV loaded successfully");
                    mOpenCvCameraView.enableView();
                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("opencv", "called onCreate");
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.camera_pic);
        mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.HelloOpenCvView);
        mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);
        
    }

    @Override
    public void onResume()
    {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_11, this, mLoaderCallback);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    public void onCameraViewStarted(int width, int height) {
    }

    public void onCameraViewStopped() {
    }

    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return inputFrame.gray();
    }

 /*   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap thumbnail = null;

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {

                thumbnail = (Bitmap) data.getExtras().get("data");
                ImageView imageView = (ImageView)findViewById(R.id.edgeDetection);
                imageView.setImageBitmap(thumbnail);
            }
       if(requestCode == EDGE_DETECTION_RESULT && resultCode == RESULT_OK)
        {
                thumbnail = edgeDetectionOutput();
                ImageView outputView = (ImageView)findViewById(R.id.outputImage);
                outputView.setImageBitmap(thumbnail);

        }

        }
/*    public void edgeDetectionOutput() {
        ImageView imageView = (ImageView) findViewById(R.id.edgeDetection);
        ImageView outputImageView = (ImageView) findViewById(R.id.outputImage);

        Bitmap input = imageView.getDrawingCache();
       Mat inputMat = new Mat();

        Bitmap output = outputImageView.getDrawingCache();
        Mat outputMat = new Mat(inputMat.size(),inputMat.type());
        Mat tmp = new Mat(inputMat.size(),inputMat.type());

        Utils.bitmapToMat(input, inputMat);
        Utils.bitmapToMat(output, outputMat);

        outputMat.setTo(inputMat);
        Utils.matToBitmap(outputMat,output);
        outputImageView.setImageBitmap(input);



        Size ksize = new Size(3, 3);
        Imgproc.blur(inputMat, outputMat, ksize);
        Imgproc.cvtColor(outputMat, tmp, Imgproc.COLOR_BGR2GRAY);

        Mat edgesMat = new Mat(inputMat.size(),inputMat.type());
        Imgproc.Canny(tmp, edgesMat, 10, 50);

        Utils.matToBitmap(edgesMat, output);
        outputImageView.setImageBitmap(output);


    }   */
}

