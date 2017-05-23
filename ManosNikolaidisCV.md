---
title: Manos Nikolaidis
---
#### Software Engineer

## Professional Experience

#### [Pulselive Ltd](http://pulselive.com/)
*London, UK (February 2016 – now)*

I create microservices with *Java SE 8* as a member of the backend team. The main functionality is to
record all match events (goals, red cards, substitutions etc) from a data feed and provide aggregated stats for teams,
players and competitions. I've been involved in the official websites for [Premier League](https://www.premierleague.com)
and [World Rugby](http://www.worldrugby.org) and also supported the pertinent mobile apps.
These are high traffic websites, so optimizing SQL queries and caching are prominent activities.
I have also dealt with push notifications for mobile apps, secure login in websites and software clients
for external APIs. I typically deal directly with product management, creative, front-end departments
and external partners.

Other tech we use includes *Spring-Boot, Hibernate, MySQL, thrift, Maven, Linux* and about
half the services provided by *AWS*.

#### Pilotware Ltd
*London, UK (February 2015 – February 2016)*

I designed and developed a service for Natural Language Processing. The input was text in English and
the output an XML document with information extracted from the text. NLP was based on the CoreNLP library
from Stanford University and the functionality was quite more advanced than what is achievable with regex or sentiment analysis.
To provide the required latency and throughput and allow software updates on a running system without downtime,
I came up with an architecture composed of multiple instances in different servers behind a load balancer and messaging to update
configuration at runtime. I was also tasked with leading a small team around this project, including a
front-end engineer and a few research scientists. All services ran at in-house servers and I cooperated
with a dedicated sysadmin for deployment, monitoring etc.

Tech used included *JavaSE 8, CoreNLP, Maven, ActiveMQ, Linux.*

#### [Shadow Robot Company Ltd](https://www.shadowrobot.com)
*London, UK (August 2013 – February 2015)*

I designed and developed software for real-time control of anthropomorphic robots.
That was PC-based control, in the sense that a server running *Linux* received (*TCP/IP*) the current position of the robot,
compared with the desired motion it should perform and issued new position commands. This required
sub-millisecond latency which in turn required some Linux black magic, like pinning threads to CPU cores,
real-time thread scheduling, locking memory before the control loop started and other low-level stuff.
This was implemented in *C++*, while *Python* was used for some coordination and monitoring tasks without low-latency requirements.

I mostly worked on Shadow's flagship product the [Dexterous Hand](https://www.shadowrobot.com/products/dexterous-hand)
and secondarily on [RoNeX](https://www.shadowrobot.com/ronex-available-for-pre-order/).
I was involved in the [Moley robot chef](https://www.bbc.co.uk/news/science-environment-32282131) project, where I wrote the software that
coordinated in real-time (1 KHz rate) the motion of 4 robots (2 hands and 2 arms). I proudly represented
Shadow at [Ros Kong 2014](https://events.osrfoundation.org/ros-kong-2014/) including a lightning talk.
Some of the code I contributed to is open source at Github. E.g. [ros_ethercat](https://github.com/shadow-robot/ros_ethercat)

Tech we used included *ROS, Boost, Eigen, libuv, Pthreads, MongoDB, Linux*

#### [Inos Automationssoftware GmbH](http://www.inos-automation.de/index.php/en/)
*Athens, Greece – Stuttgart, Germany (April 2008 – August 2013)*

I wrote software in *C++* for robotic vision applications in the automotive industry.
That was PC-based robot control software, running on a server connected (*TCP/IP*) to digital cameras,
other sensors, industrial robotic manipulators and other servers in the factory including databases.
I was mostly involved in the core libraries and the "state machine" that coordinated all other
systems connected to our servers and internal libraries for computer vision. The "state machine"
typically employed a thread, a socket and a config file per other system connected.
I regularly travelled from our R&D department at Athens to factories around our sales and support center at Stuttgart.

I was involved in the Daimler SMA212 project for quality inspection on doors in assembled
Mercedes E-Class cars. That involved 4 servers and more than 100 cameras. Also spent a lot of time
at the Audi KLT Depalletizing project and the KUKA USPS project. Both involved robots that picked boxes from pallets
at automated warehouses. Our robot vision guidance system processed data from 3D laser scanners and
digital cameras to find the boxes on the pallets. At some point, I also wrote copy-protection software
depending on USB dongles.

Tech we used included *Boost, PCL, MySQL, Qt, Git, Windows SDK*.

#### Independent Contractor
*Volos, Greece (May 2004 – March 2008)*

I cooperated with various integrators around my home town on industrial machinery projects.
They built a machine in their workshop and installed on the customer's site and I was contracted to write
software for a PC to control and monitor this machine. Software was desktop applications
written in *C++* with frameworks like *Qt*. Apart from communicating with a machine, 2D graphics
had to be displayed in real-time representing an object's shape and the cutting tool's path. At least
2 threads were involved per application.

Projects included a 2D plasma cutter for metal sheets and a machine cutting and drilling large steel beams
used in metal buildings.

## Education
#### [MSc Mechanical Engineering University of Patras](http://www.mead.upatras.gr/lang_en/)

Selected courses pertinent to control systems, statistics, time-series and robotics. Lots of math problem
solving with computers.

Master thesis : *"Simulation and control of robotic manipulators with elastic links"*. Wrote software
in *C++* to implement simulation and control algorithms. Heavy use of linear algebra and 3D transformations.
Due to heavy computations involved and my slow computer, spent a lot of time manually optimizing code and
also used profile guided optimization as provided by *Visual C++*.

#### Military Service
*May 2003 - May 2004*

Compulsory military service in the Greek Army. I was selected to serve in the Military Police, with a rank
of Sergeant. Most likely, by an SQL query that didn't perform very well.
