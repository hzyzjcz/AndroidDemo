package com.zhouxiaofeng.demo;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import java.util.List;

/**
 * Created by xiaof on 2018/1/17.
 */

public class SuperService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        //根据文本,返回文本对应的View
        //通常需要配合getParent(),或者getChild(),方法一起使用;
        //拿到View之后,就可以调用"单击事件","滚动事件",等所有支持的事件了
        //info.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        //listNode.performAction(AccessibilityNodeInfo.ACTION_SCROLL_FORWARD);
//检测当前是那个界面,也是通过查找这个界面固有的文本信息,来判断;
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
//        AccessibilityNodeInfo listNode = source.getChild(0).getChild(1);
//        List<AccessibilityNodeInfo> itemList = listNode.findAccessibilityNodeInfosByText("文本");
          List<AccessibilityNodeInfo> list = source.findAccessibilityNodeInfosByText("赵海东");
        Toast.makeText(this, list.size()+"", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }

    }

    @Override
    public void onInterrupt() {
        Toast.makeText(this, "onInterrupt()", Toast.LENGTH_SHORT).show();
}
}
