package net.summerframework.mvc.common;

import net.summerframework.mvc.routing.RouteData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://www.SummerFramework.net
 * Joseph Zhu
 * yzhu@live.com
 */
public class HttpContext
{
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private RouteData routeData;

    public HttpContext(HttpServletRequest request, HttpServletResponse response)
    {
        this.request = request;
        this.response = response;
        this.response.setCharacterEncoding("utf-8");
    }

    public RouteData getRouteData()
    {
        return routeData;
    }

    public void setRouteData(RouteData routeData)
    {
        this.routeData = routeData;
    }

    public HttpServletRequest getRequest()
    {
        return request;
    }

    public HttpServletResponse getResponse()
    {
        return response;
    }

    public void write(String content)
    {
        try
        {
            response.getWriter().write(content);
            response.getWriter().flush();
        }
        catch (Exception exception)
        {

        }
    }
}
