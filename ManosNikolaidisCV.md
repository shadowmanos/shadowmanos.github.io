## Professional Experience

#### [Callsign Ltd](https://callsign.com)
*London, UK (January 2018 – now)*

Tech Lead of the Identity and Access Management team. Design and build a secure datastore and REST API for users, admins, groups, permissions etc.
Requirements for low latency around 10ms, 5 nines availability and more than 20 million end users. Small team with other Java devs, front-end and QA.
Using various standards for APIs like [OAuth2](https://en.wikipedia.org/wiki/OAuth#OAuth_2.0) and [SCIM](https://en.wikipedia.org/wiki/System_for_Cross-domain_Identity_Management).
Involved in recruiting other Java platform engineers.

Tech stack: *Java, Spring-Boot (MVC, Data, Security), Hazelcast, PostgreSQL, ANTLR, Docker, Gatling, nginx*

#### [Pulselive Ltd](https://www.pulselive.com)
*London, UK (February 2016 – December 2017)*

Worked on backend services to provide data to sports websites and mobile apps including [Premier League](https://www.premierleague.com) and [World Rugby](https://www.world.rugby).
The premier league mobile app has 5 million downloads and combined with web traffic results in 100s of millions of requests on match day.
We processed a real time data feed with all match events (goals, red cards, substitutions etc) and
through our REST API we provided both single events as they happened and aggregated stats for teams, players and competitions.
Optimizing slow SQL queries, improving multiple layers of caching and deploying new versions to AWS were daily activities.
I have also implemented push notifications for mobile apps and authentication for websites.
Dealt directly with product management, creative, front-end engineers and external partners.

Tech stack: *Java, Spring-Boot (MVC, Data, Batch), MySQL, thrift, Docker, nginx* and about half the services provided by *AWS*.

#### Pilotware Ltd
*London, UK (February 2015 – February 2016)*

I designed and developed a service for Natural Language Processing.
It received text files like news articles in plain English and generated an XML document with interesting info like company acquisitions or speculation on commodity prices.
NLP was based on the CoreNLP library from Stanford University and functionality was way beyond what can be achieved with regex or sentiment analysis.
Since everything ran on on-premises servers, I came up with and implemented a message queues and pub/sub based architecture for load balancing and live updates without downtime.
I led the small team tasked to deliver this project, including a front-end engineer and a few research scientists.

Tech stack: *Java, CoreNLP, Jackson, ActiveMQ*

#### [Shadow Robot Company Ltd](https://www.shadowrobot.com)
*London, UK (August 2013 – February 2015)*

I designed and developed software for real-time control of anthropomorphic robots.
That was PC-based control, in the sense that a server running *Linux* received (*TCP/IP*) the current position of the robot,
compared with the desired motion it should perform and issued new position commands.
This required sub-millisecond latency which in turn required some Linux black magic, like pinning threads to CPU cores,
real-time thread scheduling, locking memory at start up and other low-level stuff.
This was implemented in *C++*, while *Python* was used for some coordination and monitoring tasks without low-latency requirements.

I mostly worked on Shadow's flagship product the [Dexterous Hand](https://www.shadowrobot.com/products/dexterous-hand)
and secondarily on [RoNeX](https://www.shadowrobot.com/ronex-available-for-pre-order).
I was involved in the [Moley robot chef](https://www.bbc.co.uk/news/science-environment-32282131) project, where I wrote the software that
coordinated in real-time (1 KHz rate) the motion of 4 robots (2 hands and 2 arms).
I proudly represented Shadow at [Ros Kong 2014](https://events.osrfoundation.org/ros-kong-2014) including a lightning talk.
Some of the code I contributed to is open source at Github. E.g. [ros_ethercat](https://github.com/shadow-robot/ros_ethercat)

Tech stack: *C++, Python, ROS, Boost, Eigen, libuv, Pthreads, MongoDB*

#### [Inos Automationssoftware GmbH](https://www.inos-automation.de/home)
*Athens, Greece – Stuttgart, Germany (April 2008 – August 2013)*

I wrote software in *C++* for robotic vision applications in the automotive industry.
That was PC-based robot control software, running on a server connected (*TCP/IP*) to digital cameras,
other sensors, industrial robotic manipulators and other servers in the factory including databases.
I mostly worked on the core libraries and the "state machine" that coordinated all other
systems connected to our servers and internal libraries for computer vision.
The "state machine" typically employed a thread, a socket and a config file for each robot or server.
I regularly travelled from our R&D department at Athens to factories around our sales and support center at Stuttgart.

I was involved in the Daimler SMA212 project for quality inspection on doors in assembled Mercedes E-Class cars.
That involved 4 servers and more than 100 cameras.
Also spent a lot of time at the Audi KLT Depalletizing project and the KUKA USPS project.
Both involved robots that picked boxes from pallets at automated warehouses.
Our robot vision guidance system processed data from 3D laser scanners and digital cameras to find the boxes on the pallets.
At some point, I also wrote copy-protection software employing USB dongles.

Tech stack: *C++, Boost, PCL, MySQL, Qt, Git, Windows SDK*.

#### Independent Contractor
*Volos, Greece (May 2004 – March 2008)*

I cooperated with various integrators around my home town on industrial machinery projects.
They built and installed a machine cutting metal/stone/wood etc and I was contracted to write custom software for a PC to control and monitor this machine.
My software was a desktop application written in *C++* and would communicating with the machine through a serial port and
display 2D graphics in real-time representing an object's shape and the cutting tool's path.
My first exposure to multi-threading and it mostly went well.

Projects included a 2D plasma cutter for metal sheets and a machine cutting and drilling large steel beams used in metal buildings.

Tech stack: *C++, wxWidgets, Windows SDK*.

## Education
#### [MSc Mechanical Engineering University of Patras](http://www.mead.upatras.gr/lang_en/)

Selected courses pertinent to control systems, statistics, time-series and robotics.
Studied numeric methods for things like differential equations and nonlinear optimization.

Master thesis: *"Simulation and control of robotic manipulators with elastic links"*.
Wrote software in *C++* to implement simulation and control algorithms. Heavy use of linear algebra and 3D transformations.
Due to heavy computations involved (and my slow PC!), spent a lot of time manually optimizing code and even used profile guided optimization as provided by *Visual C++*.

#### Military Service
*May 2003 - May 2004*

Compulsory military service in the Greek Army. I was selected to serve in the Military Police, with a rank
of Sergeant. Most likely, by an SQL query that didn't perform very well.
