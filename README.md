<!-- PROJECT LOGO -->
<br />

<p align="center">
  <h3 align="center">InfectStatisticWeb</h3>
  <p align="center">
    An infect statistic web application
    <br />
    <a href="https://github.com/xjliang/InfectStatisticWeb"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/xjliang/InfectStatisticWeb/blob/master/README.md#online-demo">View Demo</a>
    ·
    <a href="https://github.com/xjliang/InfectStatisticWeb/issues">Report Bug</a>
    ·
    <a href="https://github.com/xjliang/InfectStatisticWeb/issues">Request Feature</a>
  </p>



</p>



<!-- TABLE OF CONTENTS -->

## Table of Contents

* [About the Project](#about-the-project)
  * [Screenshots](#screenshots)
  * [Online Demo](#online-demo)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)



<!-- ABOUT THE PROJECT -->

## About The Project

[![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/overview.png?raw=true)](https://example.com)


| Homework Link         | [https://edu.cnblogs.com/campus/fzu/2020SPRINGS/homework/10460](https://edu.cnblogs.com/campus/fzu/2020SPRINGS/homework/10460) |
| --------------------- | ------------------------------------------------------------ |
| Paired student number | 22171107 & 221701137                                         |


At present, the epidemic situation of new coronavirus pneumonia has come to a very critical period. Schools are stilll waiting for its ending. A statistics website will provide a corresponding log text every day to record the situation of the provinces in the country the previous day.

The previous [epidemic statistics](https://github.com/xjliang/InfectStatistic-main) results are only displayed in text. which is not Intutive and specific. In the project, we can visually display the general distribution of the epidemic situation int the form of charts, and we can check the epidemic statistics of specific privinces.

**1. Use different colors on the national map to represent the approximate number of confirmed people**

- You can choose specific dates
- The depth of the color indicates the severity of the epidemic, and you can intuitively understand the high-risk areas
- Province will highlight on mouse over
- You can see the specific situation of the province you clicked

**2. Click on a province to show the specific situation of the province**

- You can choose specific dates
- Show the number of infected patients, the number of suspected, cures, deaths corresponding to the province
- New confirm, suspected, cure and death trends of the province so far
- Plot the trend of the province



### Online Demo

[http://118.178.139.122:8080/infect/epidemic/overview](http://118.178.139.122:8080/infect/epidemic/overview) (this demo will get expired aftere 2020-04-13)



### Screenshots

- show infect map chart

![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/infect-map-min.gif?raw=true)



- display charts within specified time

![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/infect-time-selector-min.gif?raw=true)



- toggle display of line chart

![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/infect-total-suspect-min.gif?raw=true)



- display tread of  selected province

![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/infect-tread-min.gif?raw=true)



- sort province by specified item

![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/infect-sort-min.gif?raw=true)



- pause or click specific time point in timeline

![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/infect-timeline-min.gif?raw=true)



- compare provinces side by side

![](https://github.com/xjliang/InfectStatisticWeb/blob/master/assets/infect-compare-by-province-min.gif?raw=true)



### Built With

This section should list any major frameworks that you built your project using. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.
* [spring boot](https://spring.io/projects/spring-boot)
* [echarts](https://echartsjs.com)



<!-- GETTING STARTED -->

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.

- Java JDK
- MySQL

### Installation

1. Clone the repo

```sh
$ git clone https://github.com/xjliang/InfectStatisticWeb.git
```
2. Import sql script: [infect_statistic.sql](https://github.com/xjliang/InfectStatisticWeb/tree/master/sql/infect_statistic.sql)

```mysql
$ mysql -uroot -p
mysql > create database `infect_statistic`;
mysql > exit
$ mysql -uroot -p infect_statistic < <this repo localtion>/sql/infect_statistic.sql
```

**NOTE**: you should check the datasource configuration in [application.yml](https://github.com/xjliang/InfectStatisticWeb/blob/master/src/main/resources/application.yml), where username and password are differ from everyone.

1. Build an executable JAR

```sh
$ mvn clean package
```
3. Run 

```sh
$ java -jar target/infect-0.0.1-SNAPSHOT.jar
```



<!-- USAGE EXAMPLES -->

## Usage

### start application

open your browser, and type

```
http://localhost:8890/epidemic/total
```

to start the application.



_For more examples, please refer to the [Documentation](https://example.com)_



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->

## Contact

Your Name - gnulxj@gmail.com

Project Link: [https://github.com/xjliang/InfectStatisticWeb](https://github.com/xjliang/InfectStatisticWeb)
