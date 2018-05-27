# Lorem datum

Lorem datum is a pseudo-random generator based data generation suite, which can 
be used to simulate some real-life data. It provides some nice features that make 
it easier than rolling your own data generation functions.

## Features

* Set the amount of variation between consequetive data points
* Set the probability of NA values (or disallow NA values)
* Set hard lower/upper bounds for generated values
* Ability to provide the PRNG seed, so that data generation is repeatable
* Use the date/time generator to create time series

## Available data generators

* Temporal:
  * Date/time (non-random, using java.time.LocalDateTime)
  
* Categorical:
  * Boolean
  
* Numerical:
  * Integer
  * Float
  * Double
  * Long
  
# Testing

Unit tests are provided in the (/src/test) directory, using [TestNG](http://testng.org).
They follow the same package structure and all the code on the generators should
be sufficiently covered with tests to guarantee proper workings.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) 
file for details
