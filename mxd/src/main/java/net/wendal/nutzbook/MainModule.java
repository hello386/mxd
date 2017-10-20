package net.wendal.nutzbook;

import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
                                        "*anno", "net.wendal.nutzbook",
                                        "*tx", //
                                        "*async"}) //
@SetupBy(value=MainSetup.class)
@Modules(scanPackage=true)
@Ok("json:full")
@Fail("jsp:jsp.500")
public class MainModule {

}
