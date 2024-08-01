# MedExpress Consultation

## Overview

A service which serves the backend of MedExpress's consultation process.

The consultation process comprises the following steps:
1. a user is asked a series of questions relating to a condition they are experiencing to determine their eligibility for a medicine used to treat said condition.
2. the answers they provide then inform a response served to the frontend indicating whether they are eligible for medication.

## Requirements

* Java 17
* Maven
* A desire to remedy your condition!

## Tech

A brief set of explanations as to the rationale underpinning the tech decisions made:

- Java 17 was selected as it's more than modern and stable enough for this project's requirements. Additionally, I personally haven't yet had enough exposure to Java 21 to make a good case for its use, over Java 17.
- The project was written as a Spring Boot microservice for a number of reasons:
  - ease of development (takes care of a lot of boilerplate)
  - embedded server included
  - by virtue of the task brief, there is no existing code to have to integrate with. Had this been posed as a feature to add to a modulith, this MVP might have been written as a module within said modulith.
- Maven is used as a build tool primarily because it is the option with which I am most familiar. Additionally, it has an excellent ecosystem and is popular enough so that it is likely that any future developers working on this project, would also be familiar with it.
- H2 in-memory storage was used as a means to keep the service's data access uncomplicated. H2 possesses enough functionality so that data access can, at least to some degree, be realistically emulated.

## Running Locally

To run this application locally, please follow the following steps:

1. Clone this repository to your local machine:
```
git clone <repository-url>
```


