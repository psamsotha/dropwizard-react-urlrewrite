
# React Browser History Routing with Dropwizard Backend Example

This project is an example of how to use URL rewriting (in a Dropwizard application) to allow for use of
React Router's `BrowserHistory`. The purpose is to allow for using HTML5 URLs (without the #).

In this project, this is accomplished with the use of the popular [Tucky UrlRewriteFilter][rewrite-filter].
We register the filter with Dropwizard's servlet environment.

```java
@Override
public void run(ExampleConfiguration configuration, Environment environment) throws Exception {
    FilterRegistration.Dynamic registration = environment.servlets()
            .addFilter("UrlRewriteFilter", new UrlRewriteFilter());
    registration.addMappingForUrlPatterns(null, true, "/*");
    registration.setInitParameter("confPath", getConfPath(configuration));
}
```

The other requirement is to have a configuration file, which we have (`src/main/resources/urlrewrite.xml`).
The file includes only one rule, which will tell the rewriter to forward all requests to matching paths
directly to the `index.html` file.

```
<urlrewrite>
    <rule>
        <from>^/(?!(api|static/|manifest\.json|assets-manifest\.json|favicon\.ico)).*$</from>
        <to type="forward">/index.html</to>
    </rule>
</urlrewrite>
```

The client app is built with [create-react-app][create-react-app]. When you build the client app,
you will see all of the artifacts in the `build` folder of the `client-app`. Uf you look
at the rewrite configuration, you will see that all those files are listed in the matching.
We aer saying that if any request URL _does NOT_ match (negative lookahead), then forward the request.
If the URLs do match, then just let the request go on its business as usual.


### Install Dependencies and Build

```
cd client-app && npm i && npm run build && cd ../ && mvn clean package
```

This will install both the client dependencies and server dependencies and then first build
the client project and then the server project. The client distribution files will get
copied from the client build dir to the server build dir so that we can just run the
server artifact.

### Run

```
java -jar server-app/target/server-app-0.0.1.jar server server-app/example.yml
```

### Endpoints

Base `http://localhost:8080`

#### Client

* `/`
* `/about`
* `/contact`
* `/contact/phone`
* `/contact/twitter`

#### Server

* `/api/example`

If you open a browser and browse to `/contact/twitter`, you should see the page.


[rewrite-filter]: http://tuckey.org/urlrewrite/
[create-react-app]: https://github.com/facebookincubator/create-react-app