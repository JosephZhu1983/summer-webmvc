package net.summerframework.mvc.config;

import net.summerframework.mvc.action.ActionMethodValidators;
import net.summerframework.mvc.action.IActionInvoker;
import net.summerframework.mvc.controller.IControllerFactory;
import net.summerframework.mvc.filter.FilterProviders;
import net.summerframework.mvc.filter.IFilterProvider;
import net.summerframework.mvc.routing.*;
import net.summerframework.mvc.view.IViewEngine;
import net.summerframework.mvc.view.ViewEngines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class ConfigCenter
{
    private static final ConfigCenter instance = new ConfigCenter();
    private final Logger logger = LoggerFactory.getLogger(ConfigCenter.class);
    private final RouteTable routeTable = new RouteTable();
    private IControllerFactory controllerFactory;
    private IActionInvoker actionInvoker;
    private FilterProviders filterProviders = new FilterProviders();
    private ActionMethodValidators actionMethodValidators = new ActionMethodValidators();
    private ViewEngines viewEngines = new ViewEngines();

    private ConfigCenter()
    {
    }

    public static ConfigCenter getInstance()
    {
        return instance;
    }

    public ActionMethodValidators getActionMethodValidators()
    {
        return actionMethodValidators;
    }

    public FilterProviders getFilterProviders()
    {
        return filterProviders;
    }

    public void removeAllFilterProviders()
    {
        filterProviders.clear();
    }

    public void addFilterProvider(IFilterProvider filterProvider)
    {
        filterProviders.add(filterProvider);
    }

    public ViewEngines getViewEngines()
    {
        return viewEngines;
    }

    public void removeAllViewEngines()
    {
        viewEngines.clear();
    }

    public void addViewEngine(IViewEngine viewEngine)
    {
        viewEngines.add(viewEngine);
    }

    public IActionInvoker getActionInvoker()
    {
        return actionInvoker;
    }

    public void setActionInvoker(IActionInvoker actionInvoker)
    {
        this.actionInvoker = actionInvoker;
    }

    public IControllerFactory getControllerFactory()
    {
        return controllerFactory;
    }

    protected void setControllerFactory(IControllerFactory controllerFactory)
    {
        this.controllerFactory = controllerFactory;
    }

    public RouteTable getRouteTable()
    {
        return routeTable;
    }

    protected void addRoute(String routeName, IRoute route)
    {
        routeTable.put(routeName, route);
    }

    protected void addDefaultRoutePattern(String routeName, String pattern)
    {
        try
        {
            addRoute(routeName, new DefaultRoute(pattern));
        }
        catch (Exception e)
        {
            logger.warn(e.getMessage());
        }
    }

    protected void removeAllRoutes()
    {
        routeTable.clear();
    }

}
