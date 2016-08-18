package net.devwiki.common.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 通用的ViewHolder
 * Created by DevWiki on 2016/8/18.
 */

public class ViewHolder {

    private View convertView;
    private SparseArray<View> views;

    private ViewHolder(Context context, ViewGroup parent, int layoutId) {
        this.views = new SparseArray<>();
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    /**
     * 获取ViewHolder实例
     *
     * @param context     上下文
     * @param convertView item的根view
     * @param parent      父类容器
     * @param layoutId    item布局资源文件id
     * @return ViewHolder实例
     */
    public static ViewHolder getHolder(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId);
        }
        return (ViewHolder) convertView.getTag();
    }

    /**
     * 获取View
     *
     * @param id  view的id
     * @param <T> View的实际类型
     * @return childView
     */
    public <T extends View> T get(int id) {
        View childView = views.get(id);
        if (childView == null) {
            childView = convertView.findViewById(id);
            views.put(id, childView);
        }
        return (T) childView;
    }

    /**
     * 获取item布局的根View
     *
     * @return convertView
     */
    public View getConvertView() {
        return convertView;
    }
}
