[TOC]

### 1. tomcat 和 http

#### 1.1 tomcat 的启动与关闭

- 下载地址：<https://tomcat.apache.org/download-90.cgi>

##### 1.1.1 Windows

**启动**

- 方式一：点击安装包目录下的 apache-tomcat-8.0.33\bin\startup.bat 文件。

**关闭**

- 方式一：点击安装包目录下的 apache-tomcat-8.0.33\bin\shutdown.bat 文件进行关闭。
- 方式二：直接关闭 cmd 终端窗口。

##### 1.1.2 Mac

- 将二进制包安装包解压后改名为 Tomcat，并复制到 /Library 目录下
- 修改权限。打开终端，输入sudo chmod 755 /Library/Tomcat。

**启动**

- cd /Library/Tomcat/bin 进入 bin 目录，sudo sh startup.sh 或者 sudo ./startup.sh start 命令启动 tomcat。

**关闭**

- cd /Library/Tomcat/bin 进入 bin 目录，sudo sh shutdown.sh 或者 sudo ./shutdown.sh stop 命令关闭tomcat。

**注：打开 http://localhost:8080 进行验证**

##### 1.1.3 常见问题

- JAVA_HOME

  没有配置 JAVA_HOME 环境变量，启动 tomcat 服务器，闪退。

- 8080 端口占用

  因为 Tomcat 默认使用 8080 端口，所以需要修改 tomcat 端口或者关闭占用 8080 端口的程序。

  修改 conf/server.xml 文件：<Connector connectionTimeout="**20000**" port="**8080**" protocol="**HTTP/1.1**" redirectPort="**8443**" />

- CATALINA_HOME 引起的问题

  安装版的 tomcat 会自动增加 CATALINA_HOME 环境变量，如果卸载 tomcat，不会卸载该环境变量。再次安装 tomcat 时，如果和以前的路径不一样，启动 tomcat 就会出问题

  解决方案：直接删除该环境变量

#### 1.2 tomcat 主要目录结构

- **bin**：tomcat 相关的命令和脚本文件

- **conf**：tomcat 服务器相关的配合文件，server.xml 核心配置

- **lib**：运行 tomcat 需要的 jar 文件

- **webapps**：存放web应用，即供外界访问的 web 资源

- **work**：tomcat 工作目录，存放 jsp 生成的 class 文件

#### 1.3 web 程序发布基本过程

- Eclipse 新建一个 Dynamic Web Project 项目(注: web module version 选择，这里选的 2.5 版本)
- 把 tomcat 安装包目录下 lib/servlet-api.jar 文件拷贝到项目的 WebContent/WEB-INF/lib 目录下(注：不需要build path)。
- 在 Java Resources/src 目录下新建一个 Servlet 。
- 在项目名上右键选择 Export 一个 war 包到 tomcat 安装包的 webapps 目录下。
- 启动 tomcat 项目，访问连接测试。如：http://localhost:8080/web_demo/HelloServlet 。

#### 1.4 WebContent 目录结构

- WebContent 下可以存放页面相关的资源，如 html、jsp、js、css 等文件，外界可以直接访问。

- META-INF

- WEB-INF：该目录下的文件外界无法非法直接访问，由 web 服务器负责调用。

  - classes：web 应用程序的字节码文件

  - lib：存放运行 web 程序需要的 jar 文件

  - web.xml: web 应用的配置文件

#### 1.5 开发环境下 web 程序发布基本过程

- 新建一个 Tomcat Server

  （File -> New -> Other -> Server）或者 (打开 Servers 窗口 -> 点击链接)  -> Apache/Tomcat v9.0 Server -> 选择 tomcat 安装包目录(如：/Library/Tomat)和 JRE 版本

- Eclipse 新建一个 Dynamic Web Project 项目(注意 web module version 选择，这里选的 2.5 版本，Target runtime 选择刚建立的  Apache Tomcat v9.0)

- 修改 web 应用的发布目录，双击 Servers 下的服务 -> 建议：选择 Use Tomcat installation 和 Deploy path 选择 tomcat 安装包下的 webapps 目录(如：/Library/Tomcat/webapps) -> 可以暂时尝试启动 tomcat (注：tomcat 为同步非阻塞方式启动)

  注：不修改的话默认在：

  eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps 下。

- 在 Java Resources/src 目录下新建一个 Servlet 。

- 1 右击 Servers 下的服务 -> Add and Remove -> 把要调试的 web 项目 add 到 右侧。

- 2 启动 tomcat 程序。

- 3 使用 Eclipse 内置浏览器测试页面：右键 Servlet.java 选择 Run on Server  -> 选择 Server

- 切换测试浏览器：Window -> Web Browser -> 选择默认浏览器(没有的话可以在 Preferences -> General -> Web Browser 中设置添加)

- 注1：如何步骤1，2执行了，可以直接在浏览器上访问，如 http://localhost:8080/web_demo2/Servlet

- 注2：如果步骤1，2没有执行，也可以直接执行步骤3，这时候会在运行前把 web 项目部署到 Server 上，然后在执行访问。

### 2. Servlet

#### 2.1 新建Servlet 项目时 web module version 选择

- 2.5 版本会使用 web.xml 作为 path 配置文件，3.0 及以上则使用注解配置 path 信息。
- Servlet 生命周期

![图片 1](/Users/tony/Desktop/java/note/teacher/Java_Web/image/图片 1.png)

![图片 2](/Users/tony/Desktop/java/note/teacher/Java_Web/image/图片 2.png)

#### 2.2 Servlet 的线程安全

- Servlet 运行多线程环境下，而且 Servlet 是单例的。

#### 2.3 ServletConfig

- 一个 Servlet 对应一个 Servletconfig 对象。

- 在 Servlet 的配置文件中，可以使用一个或多个 <init-param> 标签为 Servlet 配置一些初始化参数，并且实例对象时，会自动将这些初始化参数封装到 ServletConfig 对象中，并在调用 Servlet 的 init 方法时，将 ServletConfig 对象传递给 Servlet。之后可以通过 ServletConfig 对象得到当前 Servlet 的初始化参数信息。

#### 2.4 ServletContext

- 一个 web 应用对应一个 ServletContext 对象, 它代表当前 web 应用。
- 用途：
  - 获取 web 应用路径。
  - 获取 web 应用的初始化参数，可以使用一个或多个 <context-param> 标签为  web 应用配置一些初始化参数。
  - 使用 ServletContext 域对象共享数据。

#### 2.5 转发和重定向

- 定义

  - **转发：**指的是一个 web 资源收到客户端请求后，通知 **服务器** 去访问该应用的另外一个 web 资源进行处理。
  - **重定向：**指的是一个 web 资源收到客户端请求后，通知 **浏览器** 去访问另外一个 web 资源。

- 重定向和转发区别：

  - 转发过程结束后，浏览器地址栏保持初始的 URL 地址不变；而重定向过程结束后，浏览器地址栏中显示的 URL 会发生改变。

  - 转发是在服务器端内部将请求转发给另外一个资源；而重定向是通过响应的结果告诉浏览器去访问另外一个资源。 

  - 转发时，调用者与被调用者之间共享相同的 request 对象和 response 对象，它们属于同一个访问请求和响应过程；而重定向时调用者与被调用者使用各自的 request 对象和 response 对象，它们属于两个独立的访问请求和响应过程。 

  - 转发时的 URL 以 “/” 开头，它是相对于当前 WEB 应用程序的根目录；而重定向时，重定向的 URL 以 “/” 开头，它是相对于整个 WEB 站点的根目录。 

  - 转发只能将请求转发给同一个 WEB 应用中的资源；而重定向还可以重定向到同一个站点上的其他应用程序中的资源，甚至是使用绝对URL重定向到其他站点的资源。 

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="login" method="post" enctype="application/x-www-form-urlencoded"> -->
<form action="/web_demo2/login" method="post" enctype="application/x-www-form-urlencoded">
	用户名<input type="text" name="uname" /><br />
	密码<input type="password" name="password" /><br />
	<input type="submit" value="login" /><br />
</form>
</body>
</html>
```

```java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// @WebServlet("/login") // web module version 为 3.0 及以上版本使用注解配置 path 信息
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 1;
  // === 构造实例 ===
  public Servlet() {
    System.out.println("life constructor"); // 只会执行一次（启动服务或第一次调用时）
    super();
  }
  // === 初始化实例 ===
  @Override
  public void init(ServletConfig config) throws ServletException {
  	System.out.println("life init"); // 只会执行一次（启动服务或第一次调用时）
  	super.init(config);
  }
  // === service ===
  @Override
  protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
  	System.out.println("life service"); // 每次访问都会调用
  	// 根据提交方式，确定调用 doGet 还是 doPost 方法
  	super.service(arg0, arg1);
  }
  // === 销毁实例 ====
  @Override
  public void destroy() {
  	System.out.println("life destory"); // 只会执行一次（关闭服务或重启服务时）
  	super.destroy();
  }
  
  // === GET 方法 ===
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // response.getWriter().append("Served at: ").append(request.getContextPath());
		// 获取参数
	  // 方式一
	  // String req = request.getQueryString();
	  // System.out.println(req);
	  // System.out.println(URLDecoder.decode(req, "utf-8"));
	  // 方式二
    // tomcat8下，get方式提交的数据不存在中文乱码问题
    // 针对post方式，tomcat 默认使用 iso-8859-1 的编码，表单提交的数据，使用 utf-8 编码
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("uname");
    String password = request.getParameter("password");
    // name = new String(name.getBytes("iso-8859-1"), "utf-8");
    System.out.println(name + " --- " + password);
    // === 获取其他请求信息 ====
    // 获取提交方式 POST
    System.out.println(request.getMethod());
    // 获取 web 应用的路径 /web_demo2
    System.out.println(request.getContextPath());
    // 获取请求路径 http://localhost:8080/web_demo2/Servlet
    System.out.println(request.getRequestURL());
    // 获取请求路径，不包括 host，/web_demo2/Servlet
    System.out.println(request.getRequestURI());
    // 指定返回的 MIME 数据类型为 text/html
    // response.setContentType("text/html;charset=utf-8");
    // PrintWriter writer = response.getWriter();
    // writer.write("<html><head></head><body><font color='color'>今天周五，明天休息lalala</font></body></html>");
    // 定时刷新，时间间隔单位秒
    // response.setContentType("text/plain;charset=utf-8");
    // response.setHeader("refresh", "1");
    // response.setHeader("refresh", "3;url=/day34_web2/index.html");
    // response.getWriter().write("定时跳转lalala");
	  // === 单例 ===
		synchronized (SafeServlet.class) {
			response.getWriter().write("您是第" + count + "位访问者");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
    // === ServletConfig 对象 ===
		// 每个 Servelt 对应一个 ServletConfig 对象
		ServletConfig servletConfig = this.getServletConfig();
		// 读取 web.xml 中 Servlet 的 init-param 的配置参数
		String user = servletConfig.getInitParameter("user");
		String pwd = servletConfig.getInitParameter("pwd");
    // === ServletContext 对象 ===
		ServletContext servletContext = this.getServletContext();
		// 获取应用的路径
		String path = servletContext.getContextPath(); // /web_demo2
    // 获取真实路径
		// String path = servletContext.getRealPath("/");
    // 打印出真实路径为 /Users/tony/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web_demo2/
		// String path = request.getContextPath();
		// 获取应用的初始化参数
		String serviceNo = servletContext.getInitParameter("serviceNo");
    // 向 ServletContext 域中存储数据
		servletContext.setAttribute("dog", new Dog());
		// 从 ServletContext 中获取数据
		Dog dog = (Dog)servletContext.getAttribute("dog");
    // === 转发 ===
    // 转发路径相对于应用来说，即相对于 /web_demo2/ 来说
    request.getRequestDispatcher("/index.html").forward(request, response);
		// 向 request 域中存储数据
		request.setAttribute("name", name);
		// 从 request 域中获取数据
		String name = (String)request.getAttribute("name");
    // === 重定向 ===
    // 重定向路径相对于服务来说，即相对于 / 来说
    if (name.equals("admin") && password.equals("123")) {
      response.setStatus(302);
      response.setHeader("location", request.getContextPath() +  "/index.html");
      // 等价于
      // response.sendRedirect( request.getContextPath() + "/index.html");
    } else {
      response.setStatus(302);
      response.setHeader("location", request.getContextPath() +  "/error.html");
      // 等价于
      // response.sendRedirect( request.getContextPath() + "/error.html");
    }
    // 注：重定向时不能共享 request 对象中的数据
	}
  
  // === POST 方法 ===
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 获取请求的输入流
	  // 方式一
    // ServletInputStream inputStream = request.getInputStream();
    // byte[] buff = new byte[1024];
    // int len = inputStream.read(buff);
    // String info = URLDecoder.decode(new String(buff, 0, len), "utf-8");
    // System.out.println(info);
    // 方式二
    doGet(request, response);
	}
}
```

**Servlet 注册**

```xml
<!-- web module version 为 2.5 版本使用 web.xml 配置 path 信息 -->
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>web_demo2</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <!-- 针对整个应用的初始化参数 -->
  <context-param>
  	<param-name>serviceNo</param-name>
  	<param-value>50111</param-value>
  </context-param>
  <servlet>
    <description></description>
    <display-name>Servlet</display-name>
    <!-- Servlet 名字 -->
    <servlet-name>Servlet</servlet-name>
    <!-- Servlet 指定哪个类操作 -->
    <servlet-class>com.qf.servlet.Servlet</servlet-class>
    <!-- tomcat服务器启动时，创建对应的 servlet 对象值越大，优先级越高 -->
    <load-on-startup>1</load-on-startup>
  	<!-- servlet的初始化参数 -->
  	<init-param>
  		<param-name>user</param-name>
  		<param-value>zhangsan</param-value>
  	</init-param>
  	<init-param>
  		<param-name>pwd</param-name>
  		<param-value>12345</param-value>
  	</init-param>
  </servlet>
  <servlet-mapping>
    <!-- Servlet 名字，与 servlet 下的 servlet-name 相对应 -->
    <servlet-name>Servlet</servlet-name>
    <!-- Servlet path 配置 -->
    <url-pattern>/login</url-pattern>
    <!-- <url-pattern>login.do</url-pattern> -->
    <!-- 匹配所有 .do 结尾的路径 -->
    <!-- <url-pattern>*.do</url-pattern> -->
    <!-- 如有没有可匹配的 servlet，则匹配该 /* 或 / 路径。
				注意：1. 但也因此静态资源路径也会进行匹配导致静态资源访问不了(包括 html，jpg，jsp 等任意资源)
						 2. /*.do 写法是无效的，要么写 *.do，要么写 /*，要么写 /
						 3. / 和 /* 类似，区别在于 / 不会匹配 jsp 文件，但是 /* 会匹配。
		-->
    <!-- <url-pattern>/*</url-pattern> -->
    <!-- <url-pattern>/</url-pattern> -->
  </servlet-mapping>
</web-app>
```

#### 		2.6 路径

- 针对 web 程序， 路径中的 / 相对于 发布目录下 classes 目录，如果文件放在包下，可以不用写 /。

- 针对 java 程序， 路径中的 / 相对于 bin 目录。

- 获取正确的路径

  ```java
  String filePath = LoginServlet.class.getResource("/info.properties").getPath();
  ```

### 3. 会话管理

#### 3.1 Cookie

- 将数据保存在 **浏览器客户端** 的技术。

- 服务器把每个用户的数据以 cookie 的形式写给用户各自的浏览器，当用户使用浏览器再去访问服务器中的 web 资源时，就会带上客户端浏览器的 cookie 数据。
- 一个cookie不能超过4k，一个浏览器最多存 300 个 cookie，一个站点最多存 20 个 cookie。
- cookie 只能存字符串数据，不支持中文。
- Tomcat9 中，cookie 中不能有空格，否则会报错。

```java
import javax.servlet.http.Cookie;
// ...省略部分代码
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// === 创建 cookie 对象（注：cookie 数据不支持中文）===
	Cookie cookie = new Cookie("name", "zhangsan");
  // 设置一个新的值
  cookie.setValue("newname");
  // 设置只能用于 http 访问
  cookie.setHttpOnly(true);
  // 设置 cookie 的使用域
  cookie.setDomain("pingan.com.cn");
	// 设置到期时间，单位秒
	cookie.setMaxAge(60 * 60);
	// 到期时间，设为负值，浏览器会话结束时
	// cookie2.setMaxAge(-1);
	// 设置路径，如果路径和应用的名字不同，不会自动发送某些 cookie，默认发送本应用下的 cookie 数据
	// 路径设置为 / 后，相应站点下的任意 web 应用都可以共享某些 cookie
	cookie.setPath("/");
	// 将 cookie 发送给浏览器端
	response.addCookie(cookie);
  // === 获取针对本应用的所有 cookie ===
  Cookie[] cookies = request.getCookies();
  for (Cookie cookie : cookies) {
    System.out.println(cookie.getName());
    System.out.println(cookie.getValue());
    System.out.println(cookie.getPath());
    System.out.println(cookie.getDomain());
    System.out.println(cookie.getMaxAge());
  }
}
```

#### 3.2 Session

- 将数据保存在 **服务端** 的技术。

- 服务器在运行时可以为每一个用户的浏览器创建一个其独享的 session 对象，由于 session 为用户浏览器独享，所以用户在访问服务器的 web 资源时，可以把各自的数据放在各自的 session 中，当用户再去访问服务器中的其它 web 资源时，其它 web 资源再从用户各自的 session 中取出数据为用户服务。

- session 也属于域对象。

- 原理：

  - 访问应用时，如果创建 session，每个 session 对象会分配一个 id，称谓 JSESSIONID。

  - **服务器会将 session 的 id 以 cookie 的形式发送给浏览器端，浏览器端会存储该 id。**

  - 以后再访问应用时，浏览器将 session 的 id 发送给服务端。

  - 服务端收到 session 的 id 后，会根据 id 查找对应的 session 对象，如果没有找到，创建一个新的 session对象。

```java
import javax.servlet.http.HttpSession;
// ...省略部分代码
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // 创建 session 对象，根据 sessionid 找是否存在相关的 session 对象，如果存在则返回，如果不存在则创建
  HttpSession session = request.getSession();
  // 如果是 false，如果根据 sessionid 可以找到 session 对象则直接返回，否则返回 null
  // HttpSession session = request.getSession(false);
  // if(session != null){
  //   session.invalidate(); // 销毁session对象
  // }
  // 获取 session 对象的最近访问时间
  long lastAccessedTime = session.getLastAccessedTime();
  // 设置最大不活动时间间隔，单位秒，默认30分钟
  session.setMaxInactiveInterval(20 * 60);
  // 获取 sessionid
  System.out.println(session.getId());
  // =====================================
  // 默认 JSESSIONID 设置到浏览器的 httpOnly 属性值为 true，path 属性值为 当前应用。如果需要重写 JSESSIONID 的 cookie 属性则如下
  // 新建 cookie，存储 sessionid 的值
  Cookie cookie = new Cookie("JSESSIONID", session.getId());
  cookie.setPath("/");
  cookie.setMaxAge(30 * 60);
  // 只能通过 http 协议获取 cookie，不能通过 js 中的 document.cookie 获取 cookie
  cookie.setHttpOnly(true);
  response.addCookie(cookie);
  // =====================================
  // 作为域对象使用，只要 session 对象存在，通过 sessionid 能找到对应的 session 对象，就可以共享其中的数据
  // 设置 session 域中的值
  session.setAttribute("name", "zhangsan");
  // 获取 session 域中的值
  System.out.println(session.getAttribute("name"));
  // ==== 禁用 cookie 的处理 ====
  // 使用 encodeURL 后会将 sessionid 放在 url 后面
  // /day36_session/MainServlet;jsessionid=2761973C39B6683C69C0B8B9B6672CD6
  String newUrl = response.encodeURL(request.getContextPath() + "/MainServlet");
  response.sendRedirect(newUrl);
}
```

### 4. JSP

- JSP（Java Server Pages）本质上就是 Servlet，JSP 相当于 Java + html，第一次访问 JSP 文件时，会在 tomcat 的 work 目录下生成对应的 Java 文件，然后编译为字节码文件，执行 JSP 时，其实就是执行对应的 class 文件，并执行其中的相关方法，再次访问该 JSP 时，直接从 work 下找到对应的 class 文件执行。

- 不管是 JSP 还是 Servlet，虽然都可以用于开发动态 web 资源，但由于这2门技术各自的特点，逐渐把 servlet 作为 web 应用中的控制器组件来使用，而把 JSP 技术作为数据显示模板来使用，这样各自负责各的，Servlet 只负责响应请求产生数据，并把数据通过转发技术带给 JSP，数据的显示 JSP 来做。
- 编译后文件路径参考：eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/work/ Catalina/localhost/web_demo2/org/apache/jsp/index_jsp.java

#### 4.1 JSP 语法

##### 4.1.1 JSP 脚本

- **<%**  Java语句 **%>**

- 注：JSP 脚本中只能出现 Java 代码，不能出现其它模板元素（html相关标签）， JSP 引擎在翻译 JSP 页面时会将 JSP 脚本中的 Java 代码将被原封不动地放到 Servlet 的 _jspService 方法中。 

- 单个脚本中的 Java 语句可以是不完整的，但多个脚本片断组合后的结果必须是完整的 Java 语句。

##### 4.1.2 JSP 表达式

- **<%=** Java的表达式 **%>**
- JSP 引擎在翻译脚本表达式时，会将程序数据转成字符串，然后在相应位置用 out.write(…) 将数据输给客户端。
- 注：JSP 脚本表达式中的变量或表达式后面不能有分号 ; 。

##### 4.1.3 JSP 声明

- **<%!**  定义变量、方法等 **%>**
- JSP 声明中的 Java 代码被翻译到 _jspService方法的外面，即成为实例变量，JSP声明可用于定义 JSP 页面转换成的 Servlet 程序的静态代码块、成员变量和方法 。

##### 4.1.4 JSP 注释

- **<%--**  注释的内容  **--%>**

- 不会在页面上显示出来，编译后也不会存在，只是在 jsp 文件中提示。

#### 4.2 JSP 三大指令

- **<%@ 指令** 属性名="值" **%>**
- JSP 的指令并不直接产生任何可见输出，而只是告诉引擎如何处理 JSP 页面中的其余部分。

##### 4.2.1 include 指令

- **<%@ include** file="xxx.jsp" **%>**
- include 指令用于引入其它 JSP 页面，被引入的文件必须遵循 JSP 语法。

- 被引入的文件可以使用任意的扩展名，包括 html。
- 由于使用 include 指令将会涉及到 2 个 JSP 页面，并会把 2 个 JSP 翻译成一个 servlet，所以这 2 个 JSP 页面的指令不能冲突。

##### 4.2.2 page 指令

- 用于定义 JSP 页面的各种属性，无论 page 指令出现在 JSP 页面中的什么地方，它作用的都是整个 JSP 页面，为了保持程序的可读性和遵循良好的编程习惯，page 指令最好是放在整个 JSP 页面的起始位置。 

- 注意要把 jsp 的 Encodeing 设置为 utf-8。

- page指令的完整语法：

  **<%@ page** 

​       [ language="java" ] 

​       [ import="{ package.class | package.\* },  ..." ] 

​       [ session="true | false" ]  **//  默认 true**

​       [ buffer="none | 8kb | size kb" ] 

​       [ autoFlush="true | false" ] 

​       [ isThreadSafe="true | false" ] 

​       [ info="text" ] 

​       [ errorPage="relative_url" ] 

​       [ isErrorPage="true | false" ] 

​       [ contentType="mimeType [ ;charset=characterSet ]" | "text/html ; charset=ISO-8859-1" ] 

​       [ pageEncoding="characterSet | ISO-8859-1" ]  **// JSP 文件本身的编码方式**

​       [ isELIgnored="true | false" ] 

​	**%>**

##### 4.2.3 taglib 指令

- 用于在 JSP 页面中导入标签库。

#### 4.3 九大内置对象

##### 4.3.1 九大内置对象

| 对象实例名  | 类名                    | pageContext获取方式             |
| ----------- | ----------------------- | ------------------------------- |
| request     | HttpServletRequest      | pageContext.getRequest()        |
| response    | HttpServletResponse     | pageContext.getResponse()       |
| application | ServletContext          | pageContext.getServletContext() |
| session     | HttpSession             | pageContext.getSession()        |
| out         | JspWriter               | pageContext.getServletConfig()  |
| exception   | Throwable               | pageContext.getException()      |
| config      | ServletConfig           | pageContext.getOut()            |
| page        | Object(this) (较少使用) | pageContext.getPage()           |
| pageContext | PageContext             | --                              |

##### 4.3.2 pageContext

- pageContext 对象是 JSP 技术中最重要的一个对象，它代表当前 JSP 页面的运行环境，这个对象不仅封装了对其它 8 大隐式对象的引用，它自身还是一个域对象，可以用来保存数据。并且，这个对象还封装了web开发中经常涉及到的一些常用操作，例如包含和跳转其它资源、检索其它域对象中的属性等。

#### 4.4 四大域对象

- request

- session

- application

  application 就是 ServletContext

- pageContext

```java
// pageContext 从域中查找属性，查找顺序为 pageContext -> reqeust -> session -> application
System.out.println(pageContext.findAttribute("msg"));
```

#### 4.5 案例

**进入 servlet 层(controller 层)**

```java
// 获取所有员工数据
List<Employee> list = empDao.findAll();
// 将共享的数据放入请求对象中
request.setAttribute("empList", list);
// 转发到 jsp 文件
request.getRequestDispatcher("/list.jsp").forward(request, response);
```

**JSP文件**

```jsp
<!-- page 指令，用于定义 JSP 页面的各种属性 -->
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp 脚本，内容放在 _jspService 方法中 -->
<%
	// 局部变量
	int a = 10;
	System.out.println(a);
	Date date = new Date();
%>

<%
	for(int i = 1; i <= 6; i++ ){
%>
<h<%= i %>>biaoti</h<%=i %>>
<% } %>

<%
	for(int i = 1; i <= 6; i++ ){
		out.write("<h" + i + ">标题</h" + i + ">");
	}
%>

<!-- jsp 表达式，内容放在 _jspService 方法里
	out.print()
 -->
<%= a %>

<!-- jsp 声明 内容相当于类的成员变量和方法 -->
<%!
	public int age = 20;
	public int add(int a, int b){
		return a + b;
	}
%>

<%-- jsp 注释内容 --%>

<!-- include 指令，用于包含其他的 jsp 文件 -->
<%@ include file="head.jsp" %>

<%
  // pageContext 域对象，只针对当前的 jsp 起作用
  pageContext.setAttribute("name", "zhangsan");
  // 可以指定将数据存储到哪个域对象中
  pageContext.setAttribute("name2", "req_name", PageContext.REQUEST_SCOPE);
  // 在域对象中查找属性，顺序为 pageContext、request、session、application
  Object info = pageContext.findAttribute("name2");
  System.out.println(info); 
%>
<!-- 接收 controller 层的数据 -->
  <table border="1">
    <tr>
      <th>序号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>手机</th>
      <th>操作</th>
    </tr>
    <% 
    // 从内置的 request 对象中获取数据
    List<Employee> list = (List<Employee>)request.getAttribute("empList");
    for (Employee emp : list) {
      %>
    <tr>
      <td><%=emp.getId() %></td>
      <td><%=emp.getName() %></td>
      <td><%=emp.getSex() %></td>
      <td><%=emp.getAge() %></td>
      <td><%=emp.getPhone() %></td>
      <td>
        <a href="修改.html">修改</a>&nbsp;
        <a href="#">删除</a>
      </td>
    </tr>
    <%} %>
  </table>
</body>
</html>
```

**内嵌的 JSP 文件**

```jsp
<!-- head.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="css/a.css">
<link href="css/b.css">
<script type="text/javascript" src="js/a.js"></script>
<script type="text/javascript" src="js/b.js"></script>
```

**编译后的 Java 文件**

```java
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2019-12-15 12:14:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	public int age = 20;
	public int add(int a, int b){
		return a + b;
	}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/head.jsp", Long.valueOf(1576412075000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Date");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- page 指令，用于定义 JSP 页面的各种属性 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- jsp 脚本，内容放在 _jspService 方法中 -->\n");

	// 局部变量
	int a = 10;
	System.out.println(a);
	Date date = new Date();

      out.write('\n');
      out.write('\n');

	for(int i = 1; i <= 6; i++ ){

      out.write('\n');
      out.write('<');
      out.write('h');
      out.print( i );
      out.write(">biaoti</h");
      out.print(i );
      out.write('>');
      out.write('\n');
 } 
      out.write('\n');
      out.write('\n');

	for(int i = 1; i <= 6; i++ ){
		out.write("<h" + i + ">标题</h" + i + ">");
	}

      out.write("\n");
      out.write("\n");
      out.write("<!-- jsp 表达式，内容放在 _jspService 方法里\n");
      out.write("\tout.print()\n");
      out.write(" -->\n");
      out.print( a );
      out.write("\n");
      out.write("\n");
      out.write("<!-- jsp 声明 内容相当于类的成员变量和方法 -->\n");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!-- include 指令，用于包含其他的 jsp 文件 -->\n");
      out.write("<!-- head.jsp -->\n");
      out.write("\n");
      out.write("<link href=\"css/a.css\">\n");
      out.write("<link href=\"css/b.css\">\n");
      out.write("<script type=\"text/javascript\" src=\"js/a.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/b.js\"></script>");
      out.write('\n');
      out.write('\n');

  // pageContext 域对象，只针对当前的 jsp 起作用
  pageContext.setAttribute("name", "zhangsan");
  // 可以指定将数据存储到哪个域对象中
  pageContext.setAttribute("name2", "req_name", PageContext.REQUEST_SCOPE);
  // 在域对象中查找属性，顺序为 pageContext、request、session、application
  Object info = pageContext.findAttribute("name2");
  System.out.println(info); 

      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
```

#### 4.6 EL 表达式

##### 4.6.1 获取数据

- EL（Expression Language）表达式主要用于替换 JSP 页面中的脚本表达式，以从各种类型的域中检索 Java 对象、获取数据。使用 EL 表达式获取数据语法：**${标识符}**。
- 从指定域中获取数据。
- 获取对象属性。
- 获取集合中值。

##### 4.6.2 表达式运算

- 利用 EL 表达式可以在 JSP 页面中执行一些基本的关系运算、逻辑运算和算术运算，以在 JSP 页面中完成一些简单的逻辑运算。

| 关系运算符 | 说明 | 使用                     | 结果 |
| ---------- | ---- | ------------------------ | ---- |
| == 或 eq   | 等于 | \${ 5 == 5 } 或 \${ 5 eq 5 } | true |
| != 或 ne   | 不等于 | \${ 5 != 5 } 或 \${ 5 ne 5 } | false |
| < 或 lt   | 小于 | \${ 3 < 5 } 或 \${ 3 lt 5 } | true |
| > 或 gt   | 大于 | \${ 5 > 5} 或 \${5 gt 5} | false |
| <= 或 le   | 小于等于 | \${ 5 <= 5 } 或 \${ 5 le 5 } | true |
| >= 或 ge   | 大于等于 | \${ 5 >= 5 } 或 \${ 5 ge 5 } | false |

| 逻辑运算符 | 说明 | 使用                      | 结果         |
| ---------- | ---- | ------------------------- | ------------ |
| && 或 and  | 交集 | \${ A && B } 或 \${ A and B } | true / false |
| \|\| 或 or  | 并集 | \${ A \|\| B } 或 \${ A or B } | true / false |
| ! 或 not  | 非 | \${ !A } 或 \${ not A } | true / false |

##### 4.6.3 内置对象

- EL 表达式定义了一些内置(隐式)对象，利用这些隐式对象，开发人员可以获得对 web 中常用对象的引用，从而获得这些对象中的数据。

| **隐含对象名称** | **描**       **述**                                          |
| :--------------- | ------------------------------------------------------------ |
| pageContext      | 对应于 JSP 页面中的 pageContext 对象                         |
| pageScope        | 代表 page 域中用于保存属性的 Map 对象                        |
| requestScope     | 代表 request 域中用于保存属性的 Map 对象                     |
| sessionScope     | 代表 session 域中用于保存属性的 Map 对象                     |
| applicationScope | 代表 application 域中用于保存属性的 Map 对象                 |
| param            | 表示一个保存了所有请求参数的 Map 对象                        |
| paramValues      | 表示一个保存了所有请求参数的 Map 对象，它对于某个请求参数，返回的是一个string[]，针对的是复选框之类的数据 |
| header           | 表示一个保存了所有 http 请求头字段的 Map 对象                |
| headerValues     | 同上，返回 string[] 数组。注意：如果头里面有“-” ，例 Accept-Encoding，则要headerValues[“Accept-Encoding”] |
| cookie           | 表示一个保存了所有 cookie 的 Map 对象                        |
| initParam        | 表示一个保存了所有 web 应用初始化参数的 map 对象             |

```jsp
<!-- page 指令，用于定义 JSP 页面的各种属性 -->
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.getSession();
	request.setAttribute("age", 10);
%>
${ age == 2 } <br />
${ age eq 2 } <br />
${ age < 2 } <br />
${ age lt 2 } <br />
${ age > 2 } <br />
${ age gt 2 } <br />
${ age <= 2 } <br />
${ age le 2 } <br />
${ age >= 2 } <br />
${ age ge 2 } <br />
<%
  request.setAttribute("name", "haha");
%>
${ name != null } <br />
${ name ne null } <br />
<!-- 判断字符串是否为空 -->
${empty name }<br />
${ 10 > 2 && 10 < 100 } <br />
${ 10 > 2 and 10 < 100 } <br />
${ name == null || name == "" } <br />
${ !true } <br />
${ not true } <br />
<!-- 三目运算符 -->
${empty name ? 0 : 1 } <br />
<!-- http://localhost:8080/web_demo2/index.jsp?id=3&habit=6&habit=7 -->
<!-- 获取指定的请求参数 -->
${ param["id"] }<br /> <!-- 3 -->
${ param.id }<br /> <!-- 3 -->
${ paramValues.habit[0] }<br /> <!-- 6 -->
${ paramValues.habit[1] }<br /> <!-- 7 -->
<!-- 获取请求头的数据 -->
${header["host"] }<br />
<!-- 根据 cookie 的 name 获取 cookie 对象 -->
${ cookie["JSESSIONID"] }<br />
${ cookie["JSESSIONID"].name }<br />
${ cookie["JSESSIONID"].value }<br />
</body>
</html>
```

#### 4.7 jsp 内置标签

-  \<jsp:useBean\> 创建对象，对象会放到域中，其中：

  id 创建的对象名称

  class 类名

- \<jsp:setProperty\>设置对象的属性值，其中：

  name 表示对象的名称

  property 属性名

  value 对应的值

- \<jsp:getProperty\> 获取属性值

- \<jsp:forward page="WEB-INF/aaa.jsp"\>\</jsp:forward\> 转发

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 创建对象，对象会放入域中
	id 对象名，相当于变量名
	class 类的字符串，类的全路径 包名+类名
	scope 作用范围
 -->
<jsp:useBean id="dog" class="com.qianfeng.entity.Dog" scope="page"></jsp:useBean>

<!-- 设置属性
	name 表示要操作的对象名
	property 对象中的属性名
	value 属性对应的值
-->
<jsp:setProperty property="name" value="zhaolasi" name="dog"/>
${ dog } <br />
${ dog.name } <br />
<!-- 获取对象中指定属性 -->
<jsp:getProperty property="name" name="dog"/>
<!-- 转发
  WEB-INF 文件夹下的资源不能直接访问
-->
<%-- <jsp:forward page="index.jsp"></jsp:forward> --%>
<jsp:forward page="WEB-INF/index.jsp"></jsp:forward>
</body>
</html>
```

#### 4.8 jstl 标签

- JSTL（JSP Standard Tag Library，JSP标准[标签库](https://baike.baidu.com/item/标签库))是一个不断完善的开放源代码的 JSP 标签库，是由 apache的 jakarta 小组来维护的，主要包括：

  - 核心标签(c:) 

  - JSTL函数(fn:)

  - 格式化标签(fmt:)

  - 数据库标签

  - XML标签

- 核心标签库

  \<c:set\> 设置值，会向域中添加数据

  \<c:out\> 在jsp中显示值

  \<c:if\> 条件判断

  \<c:choose\> 多条件判断

  ​	\<c:when\>

  ​	\<c:otherwise\>

  \<c:forEach\> 循环遍历

- 使用步骤

  - 导入 jstl-1.2.jar 文件

  - 在 jsp 中导入相关的标签库。**注：引入核心标签库，前缀必须使用 "c"**
    - \<%@taglib uri=http://java.sun.com/jsp/jstl/core prefix="c" %\>

  - 格式化标签

    - \<fmt:formatNumber\> 数字格式化

    - \<fmt:formatDate\> 日期格式化

```jsp
<%@page import="java.util.ArrayList"%>
<%@page import="com.qianfeng.entity.Dog"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- taglib 引入标签库，引入jstl 的核心标签库，前缀是 c -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- taglib 引入标签库，引入jstl 的格式化标签库，前缀是 fmt -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 设置变量,放入域中
	var 变量名
	value 变量的值
 -->
<c:set value="zhangsan" var="name"></c:set>
${ name }<br />
<jsp:useBean id="dog" class="com.qianfeng.entity.Dog"></jsp:useBean>
<!-- 设置对象的属性 -->
<c:set target="${ dog }" property="name" value="bulutuo"></c:set>
${ dog.name }<br />
<!-- 输出变量
	escapeXml 设置 html 标签是否生效，true 表示不生效，false 生效
-->
<c:out value="${ name1 }" default="<h1>haha</h1>" escapeXml="false"></c:out>
<c:set var="sex" value="女"></c:set>
<!-- 单条件 -->
<c:if test="${sex == '男' }">
	<input type="radio" checked="checked" />男
	<input type="radio"  />女
</c:if>
<c:if test="${sex != '男' }">
	<input type="radio"  />男
	<input type="radio" checked="checked" />女
</c:if>
<input type="radio"  <c:if test="${sex == '男' }">checked="checked"</c:if> />男
<input type="radio" <c:if test="${sex == '女' }">checked="checked"</c:if> />女

<c:set var="score" value="40"></c:set>
<!-- 多条件 -->
<c:choose>
	<c:when test="${score > 80 && score <= 100 }">
		学霸
	</c:when>
	<c:when test="${score >= 60 && score <= 80 }">
		just so so
	</c:when>
	<c:otherwise>
		渣渣
	</c:otherwise>
</c:choose>
<%
	List<Dog> list = new ArrayList<Dog>();
	for(int i = 0; i <= 10; i++){
		Dog d = new Dog();
		d.setId(100 + i);
		d.setName("fugui" + i);
		list.add(d);
	}
	request.setAttribute("dogList", list);
%>
<table>
	<tr>
		<td>编号</td>
		<td>名字</td>
		<td>status</td>
	</tr>
	<!-- 遍历
		items 待遍历的数据
		var 遍历的每一个数据对应的变量
		varStatus 变量的状态
			count 序号
			index 索引
			first 是否第一个元素
			last 是否最后一个元素
		begin/end 开始和结束索引
		step 步长
	 -->
	<c:forEach var="dog" items="${ dogList }" varStatus="vs" begin="2" end="8" step="2">
		<tr>
			<td>${ dog.id }</td>
			<td>${ dog.name }</td>
			<td>${ vs.count } / ${ vs.index } / ${ vs.first } / ${ vs.last } </td>
		</tr>
	</c:forEach>
</table>
<!-- 针对特定格式的字符串进行操作 -->
<c:forTokens items="java-c-c++-python" delims="-" var="item">
	${item }
	<!-- java c c++ python -->
</c:forTokens>
<!--
	type
		number 数字
		currency 货币
		percent 百分比，默认不包含小数部分
	pattern 格式化样式
		# 占位符 会四舍五入
		0 占位符 如果位数不够，补0
	currencySymbol 货币的符号，默认￥
	minFractionDigits 小数部分最少多少位
-->
<!-- 10.13 -->
<fmt:formatNumber value="10.128" type="number" pattern=".##"></fmt:formatNumber>
<!-- 10.1 -->
<fmt:formatNumber value="10.1" type="number" pattern=".##"></fmt:formatNumber>
<!-- 10.10 -->
<fmt:formatNumber value="10.1" type="number" pattern=".00"></fmt:formatNumber>
<!-- 10.13 -->
<fmt:formatNumber value="10.134" type="number" pattern=".00"></fmt:formatNumber>
<!-- ￥1234567.12 -->
<fmt:formatNumber value="1234567.12345" type="currency"></fmt:formatNumber>
<!-- $1234567.12 -->
<fmt:formatNumber value="1234567.12345" type="currency" currencySymbol="$"></fmt:formatNumber>
<!-- %12.30 -->
<fmt:formatNumber value="0.123" type="percent" minFractionDigits="2"></fmt:formatNumber>
<%
	Date date = new Date();
	request.setAttribute("date", date);
%>
<!-- Tue Dec 17 23:07:35 CST 2019 -->
${ date }<br />
<!-- type
		date 日期
		time 时间
		both 日期和时间
 -->
<!-- 2019-12-17 -->
<fmt:formatDate value="${ date }" type="date"/>
<!-- 23:07:35 -->
<fmt:formatDate value="${ date }" type="time"/>
<!-- 2019-12-17 23:07:35 -->
<fmt:formatDate value="${ date }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>
```

#### 4.9 三层架构

![三层架构](/Users/tony/Desktop/java/note/teacher/Java_Web/8-JSP/res/三层架构.png)

### 5. Filter (过滤器)

- Filter 属于 Servlet 的技术，通过 Filter 可以对 web 服务器管理的所有 web 资源，如 jsp，Servlet,，静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。
- 过滤器本身并不产生请求和响应对象，它只能提供过滤作用。过滤器能够在 web 资源被调用之前检 Request 对象，修改 Request Header 和 Request 内容；在 Servlet 被调用之后检查 Response 对象，修改 Response Header 和 Response 内容。

![image-20191218230044873](/Users/tony/Library/Application Support/typora-user-images/image-20191218230044873.png)

- **使用步骤**

  - 创建 Filter 类

    自定义Filter类实现Filter接口，重写相关方法。

  - Filter 注册

    在 web.xml 中对 Filter 进行注册，设置拦截的资源，一般设置为 ”/*”。

- **过滤器的生命周期**

  - init

    Tomcat 服务器启动时，如果应用中存在 Filter，会创建 Filter 对象，并调用其初始化方法。Filter 对象只会创建一次，init 方法也只会执行一次。通过 init 方法的参数，可获得代表当前 Filter 配置信息的 FilterConfig 对象。

  - doFilter

    通过 chain.doFilter 进行实际的过滤操作，可以访问后续的资源，访问资源后，会回到 doFilter 方法中。

  - 当应用重新加载，或者关闭 tomcat 服务器时，会销毁 Filter 对象。

- **过滤器链**

  在一个  web 应用中，可以开发编写多个 Filter，这些 Filter 组合起来称之为一个 Filter 链，在 doFilter 方法中，开发人员如果调用了chain.doFilter 方法，web 服务器会检查 FilterChain 对象中是否还有其他的 Filter，如果有，则调用依次调用其余的 Filter，如果没有，则调用访问的目标资源。

  **注：访问 Filter 的先后顺序，由 Filter 在 web.xml 中的注册顺序决定。**

**Filter 文件**

```java
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class FirstFilter implements Filter {
	private FilterConfig config = null;
	// 创建 filter 实例，只会在 tomcat 启动时执行一次
  public FirstFilter() {
    System.out.println("filter constructor");
  }
	// 销毁 tomcat 实例，只会在 tomcat 销毁时执行一次
	public void destroy() {
		System.out.println("fileter destroy");
	}
	// 核心方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// === 获取请求后服务响应前处理 ===
		request.setCharacterEncoding("utf-8"); // 针对 post 提交方式
		response.setContentType("text/html;charset=utf-8"); // 针对响应
		config.getInitParameter("info");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		// === 放行请求到下一 filter 或到响应处处理，filter 处理顺序为注册时的先后顺序 ===
		chain.doFilter(request, response);
		// === 服务响应后到达客户端前处理 ===
		System.out.println("after pass");
	}
	// 初始化 tomcat 实例，只会在 tomcat 启动后初始化时执行一次
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init");
		String info = fConfig.getInitParameter("info");
		System.out.println(info);
		config = fConfig;
	}
}
```

**web.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>day38_filter</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>HelloServlet</display-name>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>com.qianfeng.servlet.HelloServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/HelloServlet</url-pattern>
  </servlet-mapping>
  <!-- 多个过滤器的访问顺序，根据web.xml中的注册顺序决定 -->
  <!-- 过滤器1 -->
  <filter>
    <display-name>SecondFilter</display-name>
    <filter-name>SecondFilter</filter-name>
    <filter-class>com.qianfeng.filter.SecondFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>SecondFilter</filter-name>
    <url-pattern>/*</url-pattern>
    <!-- 
    dispatch
    	REQUEST
				默认值
    	FORWARD
				使用 forward 转发则其后面的 response 输出则不会执行
    	ERROR
    	INCLUDE
				用 include 来转发则 include 的 servlet 执行完后，会再返回到原来的 servlet 执行 response 的输
				出（如果有）
    -->
    <dispatcher>REQUEST</dispatcher>
  </filter-mapping>
  <!-- 过滤器2 -->
  <filter>
    <display-name>FirstFilter</display-name>
    <filter-name>FirstFilter</filter-name>
    <filter-class>com.qianfeng.filter.FirstFilter</filter-class>
    <init-param>
    	<param-name>info</param-name>
    	<param-value>login</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>FirstFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
</web-app>
```

### 6. Listener (监听器)

- 监听器就是一个实现特定接口的普通 Java 程序，这个程序专门用于监听另一个 Java 对象的方法调用或属性改变，当被监听对象发生上述事件后，监听器某个方法将立即被执行。

- 在 Servlet 规范中定义了多种类型的监听器，它们用于监听的事件源分别为 ServletContext，HttpSession 和 ServletRequest 这三个域对象，主要用来监听对象的创建、销毁、属性的变化。

- **监听器分类**

  - 监听对象创建/销毁的监听器接口

    - ServlectContxtListener
    - ServletRequestListener
    - HttpSessionListener

  - 监听对象属性变化的接口

    - ServletContextAttributeListener
    - ServletRequestAttributeListener
    - HttpSessionAttributeListener

  - 其他 session 相关监听器接口

    - HttpSessionBindingListener

      监听对象绑定到 session 的事件

      **注：HttpSessionBindingListener 不需要 web.xml 配置文件**

    - HttpSessionActivationListener

      监听 HTTP 会话的 active 和 passivate 情况，passivate 是指非活动的 session 被写入持久设备（比如硬盘），active相反。

      **注：HttpSessionActivationListener 不需要 web.xml 配置文件**

**Listener 文件**

```java
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class ContextLifeListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
  // === ServletContextListener ===
  // 随着 tomcat 启动，创建 Listener 对象
  public ContextLifeListener() {
    System.out.println("context listener constructor");
  }
  // ServletContext 销毁时触发
  public void contextDestroyed(ServletContextEvent arg0)  {
    System.out.println("context destroy");
  }
  // ServletContext 初始化时触发
  public void contextInitialized(ServletContextEvent arg0)  {
    System.out.println("context init");
  }
  // === HttpSessionAttributeListener ===
  // 随着 tomcat 启动，创建 Listener 对象
  public SessionAttrListener() {
  }
  // session 添加属性时触发
  public void attributeAdded(HttpSessionBindingEvent sb)  {
    // 获取添加的数据
    String name = sb.getName();
    Object value = sb.getValue();
    System.out.println(name);
    System.out.println(value);
  }
  // session 删除属性时触发
  public void attributeRemoved(HttpSessionBindingEvent sb)  {
    System.out.println(sb.getName());
    System.out.println(sb.getValue());
  }
  // session 修改属性时触发
  public void attributeReplaced(HttpSessionBindingEvent sb)  {
    // 获取到的是替换之前的值
    System.out.println(sb.getName());
    System.out.println(sb.getValue());
    // 先获取 session 对象，再获取替换后的新值
    HttpSession session = sb.getSession();
    System.out.println(session.getAttribute(sb.getName()));
  }
  // === HttpSessionListener ===
  // 随着 tomcat 启动，创建 Listener 对象
  public SessionLifeListener() {
  }
  // session 创建时触发
  public void sessionCreated(HttpSessionEvent arg0)  {
    System.out.println("session create");
  }
  // session 销毁时触发
  public void sessionDestroyed(HttpSessionEvent arg0)  {
    System.out.println("session destroy");
  }
}
```

**web.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>day39_listener</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
	<!-- 监听器1 -->  
  <listener>
    <listener-class>com.qianfeng.listener.ContextLifeListener</listener-class>
  </listener>
	<!-- 监听器2 -->  
  <listener>
    <listener-class>com.qianfeng.listener.SessionLifeListener</listener-class>
  </listener>
	<!-- 监听器3 -->  
  <listener>
    <listener-class>com.qianfeng.listener.SessionAttrListener</listener-class>
  </listener>
  <servlet>
    <description></description>
    <display-name>TestServlet</display-name>
    <servlet-name>TestServlet</servlet-name>
    <servlet-class>com.qianfeng.servlet.TestServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>TestServlet</servlet-name>
    <url-pattern>/TestServlet</url-pattern>
  </servlet-mapping>
</web-app>
```

### 7. 文件上传与下载

#### 7.1 原始方式文件上传

**浏览器端 jsp 文件**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- 必须设置为 method="post" enctype="multipart/form-data" -->
  <form action="UploadServlet2" method="post" enctype="multipart/form-data">
  	<input type="text" name="name"/><br />
  	<input type="file" name="file" multiple /><br />
  	<input type="submit" value="upload" />
  </form>
</body>
</html>
```

**服务端**

```java
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public UploadServlet1() {
    super();
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // enctype="multipart/form-data" 采用如下方式，无法正常读取提交的参数
		String name = request.getParameter("name"); // 结果为 null
		// 解析数据麻烦
		ServletInputStream inputStream = request.getInputStream();
		byte[] buff = new byte[1024];
		int len = inputStream.read(buff);
		String info = new String(buff, 0, len);
		System.out.println(info);
    /* 服务端接收到的返回数据
      ------WebKitFormBoundary23pp7eSMYfcZoGok
      Content-Disposition: form-data; name="username"

      asda测试
      ------WebKitFormBoundary23pp7eSMYfcZoGok
      Content-Disposition: form-data; name="file"; filename="未命名aaa.txt"
      Content-Type: text/plain

      扣丁学堂333：http://www.codingke.com/cmooc/JavaEE
      ------WebKitFormBoundary23pp7eSMYfcZoGok
      Content-Disposition: form-data; name="file"; filename="java_info.txt"
      Content-Type: text/plain

      扣丁学堂：http://www.codingke.com/cmooc/JavaEE
      ------WebKitFormBoundary23pp7eSMYfcZoGok--
    */
		response.getWriter().write("");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```

#### 7.2 使用 fileupload 组件上传文件

- 导入 jar  包

  - commons-fileupload-1.2.1.jar
  - commons-io-1.4.jar

- **DiskFileItemFactory**：是创建 FileItem 对象的工厂，常用方法：

  - public DiskFileItemFactory(int sizeThreshold, java.io.File repository) ： 构造函数  。

  - public void setSizeThreshold(int sizeThreshold) ：设置内存缓冲区的大小，默认值为 10K。当上传文件大于缓冲区大小时， fileupload 组件将使用临时文件缓存上传文件，单位字节。

  - public void setRepository(java.io.File repository) ：指定临时文件目录。

- **ServletFileUpload**：负责处理上传的文件数据，并将表单中每个输入项封装成一个 FileItem 对象中，常用方法有：

  - boolean isMultipartContent(HttpServletRequest request) ：判断上传表单是否为 multipart/form-data类型。

  - List parseRequest(HttpServletRequest request)：解析 request 对象，并把表单中的每一个输入项包装成一个 fileItem 对象，并返回一个保存了所有 FileItem的list 集合。
  - setFileSizeMax(long fileSizeMax) ：设置上传文件的最大值。
  - setSizeMax(long sizeMax) ：设置上传文件总量的最大值。
  - setHeaderEncoding(java.lang.String encoding) ：设置编码格式。
  - setProgressListener(ProgressListener pListener)：设置监听。

**服务端代码**

```java
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class UploadServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public UploadServlet3() {
     super();
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建 FileItem 对象的工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 穿创建文件上传处理对象
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		// 判断表单数据类型是否为 multipart/form-data 类型
		if(ServletFileUpload.isMultipartContent(request)){
			// 对提交的数据进行解析
			try {
				// 解析请求数据
				List<FileItem> list = fileUpload.parseRequest(request);
				for (FileItem fileItem : list) {
					// 判断数据是否一般数据还是文件对象
					if (fileItem.isFormField()) {
						// 获取字段名
						System.out.println(fileItem.getFieldName());
						// 获取字段值
						//System.out.println(fileItem.getString());
						// 指定编码方式，解决中文乱码问题
						System.out.println(fileItem.getString("utf-8"));
					} else {
						// 获取文件名
						String name = fileItem.getName();
						// 将文件上传到服务器的 D:/upload文件夹下
						// String path = "D:/upload";
						// 获取服务器上，web 应用目录下的 upload 文件夹所在的绝对路径
						String path = this.getServletContext().getRealPath("/");
						System.out.println(path);
						// 如果路径不存在，创建
						File file = new File(path);
						// 获取父路径，和 upload 文件夹组成一个新路径，即文件上传到 D:/..../webapps/upload目录下
						file =  new File(file.getParent() + "/upload");
						if(!file.exists()){
							file.mkdirs();
						}
						// 获取全球唯一id（避免重名文件被替换）
						String uuid = UUID.randomUUID().toString();
						name = uuid + "_" + name;
						// 根据路径和文件名创建对象
						File newFile = new File(file.getAbsolutePath(), name);
						// 保存文件
						fileItem.write(newFile);
						// 删除缓存中数据
						fileItem.delete();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```

#### 7.4 文件下载

```java
package com.qianfeng.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public DownloadServlet() {
     super();
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("file");
		System.out.println(fileName);
		// 文件的输入流
		FileInputStream inputStream = new FileInputStream(new File("D:/upload", fileName));
		// 对路径进行url编码，会将z中文等特殊字符转换为%的形式,但是空格会变为+字符，所以命名尽量避免使用
		fileName = URLEncoder.encode(fileName, "utf-8");
		// 设置响应头，HTTP 上下文中的第一个参数是默认值是 inline，表示它可以显示在网页内或作为网页。该值可以重设为 attachment，表示它应该下载，此时大多数浏览器呈现“另存为”对话框，如果存在参数的 filename 值，会以该字段值作为文件名。
		response.setHeader("Content-Disposition","attachment;filename=" + fileName);
		// 响应的输出流对象
		ServletOutputStream outputStream = response.getOutputStream();
		byte[] buff = new byte[512];
		int len = -1;
		while((len = inputStream.read(buff)) != -1){
			outputStream.write(buff, 0, len);
		}
		inputStream.close();
		outputStream.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
```

### 8. MVC

- **Controller**：控制器，是控制请求的处理逻辑，对请求进行处理，负责请 求转发、页面的跳转 

- **View**：视图，是用户看到并与之交互的界面，比如 HTML（静态资源），JSP（动态资源）等等。 

- **Model**：模型，包含业务流程/状态的处理以及业务规则的规定，主要用来进行业务处理和数据的操作



