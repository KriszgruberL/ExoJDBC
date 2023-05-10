package bstorm.be.demoservletjava23.listeners;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class RequestListener implements ServletRequestListener {


    private static final Logger LOG = Logger.getLogger(RequestListener.class.getName());

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        request.getSession(true).setAttribute("startime", System.currentTimeMillis());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        long startime = (Long) request.getSession(true).getAttribute("startime");
        LOG.log(Level.INFO, "Request took {0} milliseconds", System.currentTimeMillis() - startime);
    }
}
