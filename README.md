[![PEP8](https://img.shields.io/badge/code%20style-pep8-orange.svg)](https://www.python.org/dev/peps/pep-0008/)
[![Python 3.6](https://img.shields.io/badge/python-3.6-blue.svg)](https://www.python.org/downloads/release/python-360/)

## Blogs REST API
- This is a blogging application written in Django REST framework

### Required Features
- Users can create an account and log in.
- Users can create a blog post.
- Users can view single blog posts.
- Users can view all blog posts.
- Users can update and delete the posts
- Users can click on a post and view more details.

### NB:

- The user can only edit, update or delete a blog post if he/she is the author.
- They have to be logged in to do this.


## Technologies & Languages

- **Postman** [https://www.postman.com/](url)
- **Python**
- **Django**
- **Django REST**

**Version control (Git)** [https://git-scm.com/](url)

# Installation and Setup
Ensure you have python installed on your machine.
If you are using linux Os, you need to install pip3 
```
sudo apt-get install python3-pip
```

Clone the repository below

```
git clone https://github.com/Keeprawteach/Blogs-REST-API.git
```

## Running the application

```bash
$ Virtual Env- "source venv venv"
$ Activating virtual - "source .venv"
$ requirements- "pip install -r requirements.txt"
$ runserver - "python3 manage.py runserver"
```
### Open Terminal and type
$ python3 manage.py runserver

### Open postman and use the below endpoints.


## Endpoints Available

| Method | Endpoint                        | Description                           | Roles         |
| ------ | ------------------------------- | ------------------------------------- | ------------  |
| POST   | /api/v1/users/register            | sign up a user                        | users         |
| POST   | /api/v1/users/login           | login a users                   | users         |
| POST    |/api/v1/posts/create| Create a single blog post          | users/admin   |
| GET    | /api/v1/posts/list  | get all posts           | Authenticated/Unauthenticated Users          |
| GET    | /api/v1/posts/detail/<str:pk>        | return a single blog post      |users           |
| PUT    |/api/v1/posts/update/<str:pk>    | update a specific blog post              | Users         |
| PATCH    |/api/v1/posts/delete/<str:pk>     | delete specific post                 | Users         |
| POST | /api/v1/posts/comment/<str:pk>         | delete a specific blog post               | Admin/users   |
| GET | /api/v1/posts/comments        | get all comments blog post               | Admin/users   |


## App Overview

| | | |
|:-------------------------:|:-------------------------:|:-------------------------:|
|<img width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/register.png"> Register API |  <img width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/error_register.png"> Unique Email/Username |<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/login.png"> Login|
|<img  width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/create.png"> Create Post |  <img width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/list.png"> List Posts |<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/detail.png"> Post Details|
|<img  width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/update.png"> Update |  <img width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/delete.png"> Delete |<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/comment1.png"> Comment|
|<img  width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/comments.png"> All Comments |  <img width="1604" alt="Login API" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/unauthorized.png"> Logged APIs |<img width="1604" alt="screen shot 2017-08-07 at 12 18 15 pm" src="https://github.com/Keeprawteach/Blogs-REST-API/blob/master/screenshots/open.png"> Open API|

### Unit Testing 
For unit testing there are 14 tests which the api must pass 

```
 python3 manage.py test 
 ```
### Author

Kiprotich Japheth

## [License](LICENSE)

MIT
