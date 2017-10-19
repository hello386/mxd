package net.wendal.nutzbook;

import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

//璇锋敞鎰忔槦鍙�!!涓嶈鎷疯礉灏戜簡
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
                    // 杩欎釜package涓嬫墍鏈夊甫@IocBean娉ㄨВ鐨勭被,閮戒細鐧昏涓�
                                        "*anno", "net.wendal.nutzbook",
                                        "*tx", // 浜嬪姟鎷︽埅 aop
                                        "*async"}) // 寮傛鎵цaop
@SetupBy(value=MainSetup.class)
@Modules(scanPackage=true)
@Ok("json:full")
@Fail("jsp:jsp.500")
public class MainModule {

}
