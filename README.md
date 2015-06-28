<h1>Introduction</h1>
<p>This application is built by Maven. Please import the project in your favorite IDE. The application needs at least Java 1.7.</p>

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
<h2>To run test application test cases, </h2>
<p>use maven test goal or start tests via IDE.</p>

<h2>Create executable jar</h2>
<p>The pom.xml already supports the creation of an executable jar while packaging the project. The jar will be in the target folder:</p>
addressbook\target\addressbook-0.0.1-SNAPSHOT-jar-with-dependencies.jar<br/>
<p>Tu run via console, do the following:<p>
<ul>
<li>Run mvn package in the root project folder</li>
<li>Run the application with: java -jar target/addressbook-0.0.1-SNAPSHOT-jar-with-dependencies.jar ~absolute-path-of-addressbook-file~<li>
</ul> 

<h2>Some statements</h2>
<p>I have decided to implement like in a typical three layered application (ui, service, data), although I am not using any kind of database or the complexity of applicaton logic is very high. The addresses are handled in memory. Therefore, I had to implement the search functions on my own. Of course, I could made the decision to run a database like h2 or mongodb which takes over the search work...</p>

<p>Sadly, I would describe myself as not very experienced in testing strategies. In former projects, the leads haven't appreciated unit/integration testing much. But I have bundled all my testing experience and the result shows now how I would start to test in a professional development environment. In a web context, I would also introduce tools like Selenium or Protractor/Jasmine and perform EndToEnd tests.</p>