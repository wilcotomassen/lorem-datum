# Lorem datum

Lorem datum is a pseudo-random generator based data generation suite, which can 
be used to simulate some real-life data. It provides some nice features that make 
it easier than rolling your own data generation functions.

**Build status**

<table>
  <tbody>
    <tr>
      <td>[Master](https://github.com/wilcotomassen/lorem-datum-core/tree/master): </td>
      <td><a href="https://travis-ci.com/wilcotomassen/lorem-datum-core"><img src="https://travis-ci.com/wilcotomassen/lorem-datum-core.svg?branch=master" alt="Build Status"/></a></td>
    </tr>
    <tr>
      <td>[Develop](https://github.com/wilcotomassen/lorem-datum-core/tree/develop): </td>
      <td><a href="https://travis-ci.com/wilcotomassen/lorem-datum-core"><img src="https://travis-ci.com/wilcotomassen/lorem-datum-core.svg?branch=develop" alt="Build Status"/></a></td>
    </tr>
  </tbody>
</table>

## Features

* Set the amount of variation between consecutive data points
* Set the probability of NA values (or disallow NA values)
* Set hard lower/upper bounds for generated values
* Ability to provide the PRNG seed, so that data generation is repeatable
* Use the date/time generator to create time series

## Available data generators

* Temporal:
  * Date/time (non-random, using java.time.LocalDateTime)
  
* Categorical:
  * Boolean
  * Categorical (any Object)
  
* Numerical:
  * Integer
  * Float
  * Double
  * Long
  
## Documentation

Documentation (javadocs) can found on the [GitHub Pages website](https://wilcotomassen.github.io/lorem-datum-core/)

## Testing

Unit tests are provided in the (/src/test) directory, using [TestNG](http://testng.org).
They follow the same package structure and all the code on the generators should
be sufficiently covered with tests to guarantee proper workings.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) 
file for details
