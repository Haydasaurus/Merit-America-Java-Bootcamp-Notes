# Final React Capstone Project Seed

This is the React starter project for the final capstone. This document walks you through how to set up and run the project. It also explains the project's features, such as React Router, Redux, and authentication.

## Project setup

The first thing you'll need to do is to download any dependencies by running this command:

```
npm install
```


Your React frontend communicates with this API endpoint to authenticate and register users.

The last thing to do is start the back-end application before you work on the front-end application. Start your application with the following command:

```
npm start
```

## Authentication

When you first run the project and visit the base URL, you're taken to a login page. This is because the home route `/` is secured by default. If you look in `/src/Components/Main/Main.js`, you'll see the following code:

```
<Switch>
    <Route path='/login' component={() => <Login/>}/>
    <Route path='/register'component={() => <Register/>}/>
    <Route path='/home' component={this.props.token.token !== undefined ? () => <Home/> : null}/>
    <Redirect to='/login'/>
</Switch>
```

The line that reads `<Redirect to='/login'/>` tells the Router to navigate to the `/login` path by default and the other `<Route/>` tags tell you which components will be loaded depending on the `to`

path variable. If you look at the `<Route/>` component with the path `/home` you'll see the component has a condition `this.props.token.token !== undefined`. This is to ensure that the home component

is only loaded if the user is authorized.



### Redux

The state for this application is stored and managed in the various files you'll find in the folder labeled `Redux`. The application has two state objects: token and user. When a user logs in, 

back-end API authorizes the request with the given credentials and then, upon successful login, the response object is parsed and then stored in the two state objects.
```
    handleLogin = async () => {
        const data = { username: this.state.username, password: this.state.password };
        

        const userWithToken = await axios.post(baseUrl + '/login', data)

    
        await this.props.dispatch(addToken(userWithToken.data.token))
        await this.props.dispatch(addUser(userWithToken.data.user));
    }
```
### Login

When you reach the `/login` route, you'll see a bare login page. This is intentional. It's up to you to style this page to fit within your application.

When you fill in a username and password and click the "Sign In" button, the method `handleLogin()` is called. The `handleLogin()` method uses the axios to send a `POST` request to your API's `/login` route.

If a successful response is returned, the response is parsed into the token and user objects and then functions are dispatched to send those objects to the Redux store.



Once the `handleLogin()` method finishes updating the store by committing the mutations, the Main component recognizes the token and redirects the user to the Home component. They'll be able to see the homepage because they're authenticated.

### Logout

When a user is logged in, they will see a `logout` link next to the `home` link. The logout link erases the token from the Redux store and deauthorizes the user.



### Register

When you reach the `/register` route, you'll see a bare registration page. Like the login page, this is intentional. You'll need to style this page to fit within your application.

When you fill in a username, password, confirm the password, and click the "Create Account" button, the method `handleSubmit()` is called. This calls the `handleLogin()`. This passes  your user details to your back-end application's REST API to create a new user:

```
    const handleSubmit = () => {
        const data = {username: username, password: password, confirmPassword: confirmPassword, role: 'ROLE_USER'}
        if(password === confirmPassword){
            axios.post(baseUrl + "/register", data)
        }
    }
```
