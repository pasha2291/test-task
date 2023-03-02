# test-task (by Pavel Leonovich)
UI/API test project created in order to pass an interview in IDF company. 4 test suites were implemented:

------------------

## Positive log in test scenario: LogInPositiveTest class  
**1) positiveLogInTest():**

| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using valid* password value.   | 1. User registered properly. API status code is 201. |
| 2. UI. Log in using previously registered credentials.|  2. Login accepted, API Authorized response is "true". User name has appeared at the top of the web page and it equals to registered user name.|
.* - Valid passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.

------------------

## Negative log in test scenario: LogInNegativeTests class
**1) registeredUserLowerCasePassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using valid* password value.   | 1. User registered properly. API status code is 201. |
| 2. UI. Log in using previously registered username, but password converted to lower case.|  2. Credentials are not accepted, error message has appeared at the web page. API Authorized response is "false".|
.* - Valid passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.

------------------

**2) registeredUserUpperCasePassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using valid* password value.   | 1. User registered properly. API status code is 201. |
| 2. UI. Log in using previously registered username, but password converted to upper case.|  2. Credentials are not accepted, error message has appeared at the web page. API Authorized response is "false".|
.* - Valid passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.

------------------

**3) registeredUserUpperWrongUserName():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using valid* password value.   | 1. User registered properly. API status code is 201. |
| 2. UI. Log in using previously registered password, but newly generated user name. |  2. Credentials are not accepted, error message has appeared at the web page. API Authorized response is "false".|
.* - Valid passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.

------------------

**4) unregisteredUser():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using short password value (under 8 characters long).   | 1. Credentials are not accepted, API status code is 400. |
| 2. UI. Log in using previously unregistered username and password values.|  2. Credentials are not accepted, error message has appeared at the web page. API Authorized response is "false".|

------------------
## Negative API user registration test scenario: ApiRegistrationNegativeTests class
**1) shortPassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using password under 8 values.   | 1. Credentials are not accepted, API status code is 400. |

------------------

**2) upperCaseMissingPassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using password with all lower cases values.   | 1. Credentials are not accepted, API status code is 400. |

------------------

**3) lowerCaseMissingPassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using password with all upper cases values.   | 1. Credentials are not accepted, API status code is 400. |

------------------

**4) digitMissingPassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using password without numeral values.   | 1. Credentials are not accepted, API status code is 400. |

------------------

**5) specialCharacterMissingPassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using password without special character values.   | 1. Credentials are not accepted, API status code is 400. |

------------------

**6) validPasswordEmptyName():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using valid* password and empty name value.   | 1. Credentials are not accepted, API status code is 400. |
.* - Valid passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.

------------------

**7) validNameEmptyPassword():**
| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Register user using empty password value.   | 1. Credentials are not accepted, API status code is 400. |

------------------

## API book list equals to UI book list test scenario: BookListTest class
**1) uiBookListEqualsApi():**

| Steps                                                |Expected result                                      |
| -------------                                        |  -------------                                      |
| 1. API. Get book list.   | 1. List is collected. API status code is 200.  |
| 2. UI. Get book list. |  2. List is collected. |
| 3. Books received from UI are equal to books from UI (Title equality)|  3. All books(titles) are equal. |  
