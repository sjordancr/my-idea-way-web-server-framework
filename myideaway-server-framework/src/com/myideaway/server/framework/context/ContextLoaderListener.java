package com.myideaway.server.framework.context;

import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.myideaway.server.framework.buffer.UserBuffer;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author charles.chen on 2012-7-13
 **/
public class ContextLoaderListener extends ContextLoader implements ServletContextListener {
	private static Log log = LogFactory.getLog(ContextLoaderListener.class);
	private ContextLoader contextLoader;

	/**
	 * Create a new {@code ContextLoaderListener} that will create a web
	 * application context based on the "contextClass" and
	 * "contextConfigLocation" servlet context-params. See {@link ContextLoader}
	 * superclass documentation for details on default values for each.
	 * <p>
	 * This constructor is typically used when declaring
	 * {@code ContextLoaderListener} as a {@code <listener>} within
	 * {@code web.xml}, where a no-arg constructor is required.
	 * <p>
	 * The created application context will be registered into the
	 * ServletContext under the attribute name
	 * {@link WebApplicationContext#ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE} and
	 * the Spring application context will be closed when the
	 * {@link #contextDestroyed} lifecycle method is invoked on this listener.
	 * 
	 * @see ContextLoader
	 * @see #ContextLoaderListener(WebApplicationContext)
	 * @see #contextInitialized(ServletContextEvent)
	 * @see #contextDestroyed(ServletContextEvent)
	 */
	public ContextLoaderListener() {
	}

	/**
	 * Create a new {@code ContextLoaderListener} with the given application
	 * context. This constructor is useful in Servlet 3.0+ environments where
	 * instance-based registration of listeners is possible through the
	 * {@link javax.servlet.ServletContext#addListener} API.
	 * <p>
	 * The context may or may not yet be
	 * {@linkplain org.springframework.context.ConfigurableApplicationContext#refresh()
	 * refreshed}. If it (a) is an implementation of
	 * {@link ConfigurableWebApplicationContext} and (b) has
	 * <strong>not</strong> already been refreshed (the recommended approach),
	 * then the following will occur:
	 * <ul>
	 * <li>If the given context has not already been assigned an
	 * {@linkplain org.springframework.context.ConfigurableApplicationContext#setId
	 * id}, one will be assigned to it</li>
	 * <li>{@code ServletContext} and {@code ServletConfig} objects will be
	 * delegated to the application context</li>
	 * <li>{@link #customizeContext} will be called</li>
	 * <li>Any {@link org.springframework.context.ApplicationContextInitializer
	 * ApplicationContextInitializer}s specified through the
	 * "contextInitializerClasses" init-param will be applied.</li>
	 * <li>
	 * {@link org.springframework.context.ConfigurableApplicationContext#refresh
	 * refresh()} will be called</li>
	 * </ul>
	 * If the context has already been refreshed or does not implement
	 * {@code ConfigurableWebApplicationContext}, none of the above will occur
	 * under the assumption that the user has performed these actions (or not)
	 * per his or her specific needs.
	 * <p>
	 * See {@link org.springframework.web.WebApplicationInitializer} for usage
	 * examples.
	 * <p>
	 * In any case, the given application context will be registered into the
	 * ServletContext under the attribute name
	 * {@link WebApplicationContext#ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE} and
	 * the Spring application context will be closed when the
	 * {@link #contextDestroyed} lifecycle method is invoked on this listener.
	 * 
	 * @param context
	 *            the application context to manage
	 * @see #contextInitialized(ServletContextEvent)
	 * @see #contextDestroyed(ServletContextEvent)
	 */
	public ContextLoaderListener(WebApplicationContext context) {
		super(context);
	}

	/**
	 * Initialize the root web application context.
	 */
	public void contextInitialized(ServletContextEvent event) {
		this.contextLoader = createContextLoader();
		if (this.contextLoader == null) {
			this.contextLoader = this;
		}
		this.contextLoader.initWebApplicationContext(event.getServletContext());
		UserBuffer.getInstance();
	}

	/**
	 * Create the ContextLoader to use. Can be overridden in subclasses.
	 * 
	 * @return the new ContextLoader
	 * @deprecated in favor of simply subclassing ContextLoaderListener itself
	 *             (which extends ContextLoader, as of Spring 3.0)
	 */
	@Deprecated
	protected ContextLoader createContextLoader() {
		return null;
	}

	/**
	 * Return the ContextLoader used by this listener.
	 * 
	 * @return the current ContextLoader
	 * @deprecated in favor of simply subclassing ContextLoaderListener itself
	 *             (which extends ContextLoader, as of Spring 3.0)
	 */
	@Deprecated
	public ContextLoader getContextLoader() {
		return this.contextLoader;
	}

	/**
	 * Close the root web application context.
	 */
	public void contextDestroyed(ServletContextEvent event) {
		if (this.contextLoader != null) {
			this.contextLoader.closeWebApplicationContext(event.getServletContext());
		}
		Enumeration<String> attrNames = event.getServletContext().getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String attrName = (String) attrNames.nextElement();
			if (attrName.startsWith("org.springframework.")) {
				Object attrValue = event.getServletContext().getAttribute(attrName);
				if (attrValue instanceof DisposableBean) {
					try {
						((DisposableBean) attrValue).destroy();
					} catch (Throwable ex) {
						log.error("Couldn't invoke destroy method of attribute with name '" + attrName + "'", ex);
					}
				}
			}
		}
	}
}
