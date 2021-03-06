### User Stories & EndPoints

## User Model
- A user can register
- A user can login
- A user can retrieve their data

## User Auth endpoints
| Request Type | URL                 | Request Body              | Request Header     | Action          | Access  |
| ------------ | ------------------- | ------------------------- | ------------------ | --------------- | ------- |
| POST         | auth/users/register | body                      |                     |                 | public  |
| POST         | auth/users/login    | body                      |                     |       | public  |
| GET          | auth/users/profile  | none                      | Authorization : Bearer TOKEN | get user info | private |


## Applications/Requirements Model
- As a user, I should be able to create an application/requirements.
- As a user, I should be able to read an application/requirements.
- As a user, I should be able to update an application/requirements.
- As a user, I should be able to delete an application/requirements.

### Applications endpoints
| Request Type | URL                              | Request Body | Request Header               | Action                               | Access  |
| ------------ |----------------------------------|--------------| ---------------------------- |--------------------------------------| ------- |
| GET          | api/applications                 | none         | Authorization : Bearer TOKEN | get all applications                 | private |
| GET          | api/applications/{appId}         | none         | Authorization : Bearer TOKEN | get a specific application for a job | private |
| POST         | api/applications/jobtype/{jobId} | body         | Authorization : Bearer TOKEN | create an application for a job      | private |
| PUT          | api/applications/{appId}         | body         | Authorization : Bearer TOKEN | update an application                | private |
| DELETE       | api/applications/{appId}         | none         | Authorization : Bearer TOKEN | Delete an application                | private |

### Requirements endpoints
| Request Type | URL                                   | Request Body | Request Header               | Action                                                        | Access  |
| ------------ |---------------------------------------|--------------| ---------------------------- |---------------------------------------------------------------| ------- |
| GET          | api/requirements/{reqId}              | none         | Authorization : Bearer TOKEN | get a specific application for a job                          | private |
| POST         | api/requirements/jobtype/{jobId}      | body         | Authorization : Bearer TOKEN | create a requirement for a job                                | private |
| PUT          | api/requirements/{reqId}              | body         | Authorization : Bearer TOKEN | Update a requirement                                          | private |
| DELETE       | api/requirements/{reqId}              | none         | Authorization : Bearer TOKEN | Delete a requirement                                          | private |
| GET          | api/requirements                      | none         | Authorization : Bearer TOKEN | get all requirements for a job                                | private |


## JobType Model (Only for backend)
- As a user, I should be able to create a jobtype.
- As a user, I should be able to view all the job types

## JobType endpoints

| Request Type | URL                       | Request Body     | Request Header               | Action       | Access  |
| ------------ | ------------------------- |------------------| ---------------------------- |--------------| ------- |
| GET          | api/jobtypes             | none             | Authorization : Bearer TOKEN | get all jobs | private |
| POST         | api/jobtypes              | body             | Authorization : Bearer TOKEN | create a job | private |


### Open Applications/Requirements endpoints

| Request Type | URL                                         | Request Body              | Request Header               | Action                                                            | Access  |
|--------------|---------------------------------------------|---------------------------| ---------------------------- |-------------------------------------------------------------------| ------- |
| GET          | api/applications/opened                     | none                      | Authorization : Bearer TOKEN | get all opened applications                                       | private |
| GET          | api/requirements/opened                     | none                      | Authorization : Bearer TOKEN | get all opened requirements                                       | private |

### Fulfilled Applications/Requirements endpoints

| Request Type | URL                                         | Request Body              | Request Header               | Action                         | Access  |
|--------------|---------------------------------------------|---------------------------| ---------------------------- |--------------------------------| ------- |
| GET          | api/applications/fulfilled                     | none                      | Authorization : Bearer TOKEN | get all fulfilled applications | private |
| GET          | api/requirements/fulfilled                     | none                      | Authorization : Bearer TOKEN | get all fulfilled requirements | private |

### Matched Applications/Requirements endpoints

| Request Type | URL                    | Request Body              | Request Header               | Action                       | Access  |
|--------------|------------------------|---------------------------| ---------------------------- |------------------------------| ------- |
| GET          | api/match/applications | none                      | Authorization : Bearer TOKEN | get all matched applications | private |
| GET          | api/match/requirements | none                      | Authorization : Bearer TOKEN | get all matched requirements | private |

