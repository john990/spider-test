package com.data.downimg;

import com.img.get.Downloader;
import com.img.get.ImgGet;
import com.img.get.info.DownloadInfo;

/**
 * Created by kai on 12/28/13.<br/>
 * Function :
 */
public class Xinli001Progress implements Downloader.DownloadListener {

    private ImgGet imgGet;

    public Xinli001Progress(ImgGet imgGet) {
        this.imgGet = imgGet;
    }

    @Override
    public void onStart(DownloadInfo downloadInfo) {
    }

    @Override
    public void onFinish(DownloadInfo downloadInfo) {
        if (imgGet.hasTask()) {
            System.out.println("all download finish!");
            System.exit(1);
        }
    }

    @Override
    public void onProgressChange(DownloadInfo downloadInfo) {
    }

    @Override
    public void onFail(DownloadInfo downloadInfo) {
        if (imgGet.hasTask()) {
            System.exit(1);
        }
    }
}
