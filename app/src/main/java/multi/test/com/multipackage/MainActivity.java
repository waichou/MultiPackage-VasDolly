package multi.test.com.multipackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.leon.channel.helper.ChannelReaderUtil;

/**
 *
 * 参考博客：
 * https://blog.csdn.net/lmj623565791/article/details/79998048
 *
 * 参考官方文档：
 * https://github.com/Tencent/VasDolly
 *
 * 官方实现原理：
 * https://github.com/Tencent/VasDolly/wiki/VasDolly%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86
 *
 * 注意：同时包含V1和V2签名的情况下，优先校验V2，没有或者不认识V2，则校验V1。
 *      之所以同时支持V1和V2签名方案，主要是担心后续Android平台加强签名校验机制，导致V2多渠道打包方案行不通，可以无痛切换到V1签名方案
 *
 * 注意：在使用adb命令安装时，需要执行： adb install -r xxxx.apk
 */
public class MainActivity extends AppCompatActivity {


    TextView mChannelTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChannelTv = findViewById(R.id.channel_tv_id);
    }

    public void getChannelNameClick(View view) {
        String channel = ChannelReaderUtil.getChannel(this);

        mChannelTv.setText(channel + "," + AppUtils.getAppVersionName());

    }
}
