# _ToJo Website_

#### _Men's sunglasses website._

#### By _**Joanna Anderson and Thomas Rivassi**_

## Description

_This application is a men's sunglasses website. It is a CMS that allows Tojo (the sunglasse's company) to add inventory, delete inventory, edit them, etc._

## Installation Requirements

1. Go to [my GitHub](https://github.com/jsaerom/tojo-website)
2. Click Clone or download and choose either the Open in Desktop option or Download Zip option
**OR**

1. Open Terminal
2. Command `$ git clone https://github.com/jsaerom/tojo-website`

In PSQL:

1. CREATE DATABASE tojo_website;
2. CREATE TABLE sunglasses (id serial PRIMARY KEY, name varchar, imgurl varchar, description varchar, price int, customerid int);
3. CREATE TABLE users (id serial PRIMARY KEY, name varchar, creditcardnum int, phone varchar, email varchar, street varchar, city varchar, state varchar, zipcode int);
4. Run the following command: `$ psql media < media.sql`

## Technologies Used

* _Java_
* _Spark_
* _HTML_
* _Velocity Template Engine_
* _CSS_
* _Bootstrap_

### License

Copyright (c) 2016 **_Joanna Anderson_**
