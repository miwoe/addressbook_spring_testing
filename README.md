<h1>Introduction</h1>
<p>Please import the project in your favorite IDE. The application needs at least Java 1.7. Maven is used for build and dependency management.</p>

<h2>To run the application</h2> 
<p>start the mwo.addressbook.ui.Bootstrap class. You can do it via IDE or creating an executable jar (see below). 
It contains the main method which</p> 
<ol>
<li>imports the addresses and</li> 
<li>outputs the results according to the tasks to the console.</li>
</ol>
<p>
You need to provide the address book file as a parameter for the main method. You will find the example from the task in root folder of the project.
</p>
<h2>To run test application test cases </h2>
<p>use maven test goal or start tests via IDE.</p>

<h2>Create executable jar</h2>
<p>The pom.xml already supports the creation of an executable jar while packaging the project. The jar will be in the target folder:</p>
addressbook\target\addressbook-0.0.1-SNAPSHOT-jar-with-dependencies.jar<br/>
<p>Tu run via console, do the following:<p>
<ul>
<li>Run mvn package in the root project folder</li>
<li>Run the application with: java -jar target/addressbook-0.0.1-SNAPSHOT-jar-with-dependencies.jar ~absolute-path-of-addressbook-file~</li>
</ul> 

