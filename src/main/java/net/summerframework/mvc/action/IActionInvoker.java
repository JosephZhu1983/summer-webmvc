package net.summerframework.mvc.action;

import net.summerframework.mvc.common.ControllerContext;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public interface IActionInvoker
{
    void invokeAction(ControllerContext controllerContext, String actionName) throws ActionInvokerException;
}
