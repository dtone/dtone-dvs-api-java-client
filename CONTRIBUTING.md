# Contributing

We'd love to accept your patches and contributions to this project.

## Reporting Issues

If you have found what you think is a bug, please [file an issue](https://git.transferto.com/java/httpclient-maven/issues/new).

## Suggesting new features

If you are here to suggest a feature, first create an issue if it does not already exist. From there, we will discuss use-cases for the feature and then finally discuss how it could be implemented.

## Development

If you have been assigned to fix an issue or develop a new feature, please follow these steps to get started:

- Fork this repository.
- Install dependencies by running `$ mvn clean install`.
- Implement your changes and tests to files in the `src/` directory and corresponding test files.
- To ensure that your changes are not breaking existing code, run the mock test cases using the command `$ mvn test`.
- Document your changes in the root `README.md` and `CHANGELOG.md`.
- Commit the code.
- Submit Pull Request for review.


## Code Quality

Contributors must ensure that minimum code quality is maintained using [sonarqube](https://www.sonarqube.org/). The code coverage of minimum `90%` and code quality gate status `passed` is preferred.

To test the code quality, 
- Configure the sonarqube properties `<sonar.login>, <sonar.password> and <sonar.host.url>` in `pom.xml`.
- Run the command `$ mvn clean verify sonar:sonar` from the root directory. 
- Check the code quality report in the sonarqube admin UI.
