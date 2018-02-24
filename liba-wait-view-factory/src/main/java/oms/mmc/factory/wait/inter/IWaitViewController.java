package oms.mmc.factory.wait.inter;

import android.app.Application;

/**
 * Package: com.wally.android.wait.inter
 * FileName: IWaitViewController
 * Date: on 2018/2/23  下午3:17
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public interface IWaitViewController<T> {
    /**
     * 解析等待对话框实现类Class
     *
     * @param waitImlClass 要解析的对话框实现类的Class
     * @return 解析出来的对话框实现类对象
     */
    IWaitView<T> parseIml(Class<? extends IWaitView<T>> waitImlClass);

    /**
     * 设置对话框实现类
     *
     * @param newWaitIml 新的对话框实现类
     */
    void setWaitIml(IWaitView<T> newWaitIml);

    /**
     * 设置对话框实现类的Class，进行解析
     *
     * @param newWaitImlClass 新的对话框实现类Class
     */
    void setWaitIml(Class<? extends IWaitView<T>> newWaitImlClass);

    /**
     * 获取对话框执行实现类
     *
     * @return 对话框实现类对象
     */
    IWaitView<T> getWaitIml();

    /**
     * 获取全局的Application对象
     * @return 全局的application对象
     */
    Application getApplication();
}