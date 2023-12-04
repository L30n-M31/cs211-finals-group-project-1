<details>
  <summary> CS211 Finals Group Project 1 📘</summary>
  | Author: Leonhard Leung <br>
  | Course: CS211 <br>
  | Class Code: 9342
</details>

## Description
This project is part of our Data Structures course for the finals. The project requires us to demonstrate the traversal methods of a graph mainly the Depth First Traversal and the Breadth First Traversal. Another requirement is to implement the Dijkstra's algorithm in finding the shortest paths between nodes in a weighted graph.

## Project Structure
- `src` contains the source code of the main program.
- `app` houses the executable class for running the application.
- `com.mxgraph` contains the library for creating a visual representation of a graph. (in courtesy of [jgraphx](https://github.com/jgraph/jgraphx)).
- `graph` includes classes responsible for creating and managing the graph data structure.
- `gui` encompasses the graphical user interface (GUI) components and structure of the application.
- `reader` contains the class responsible for reading and processing data inputs.
- `Graph Data` holds data files representing graphs to be processed by the program.

## Usage
To run the application, simply go to the app package and run the executable class

## Task Checklist
- [x] `GUIApplication.java` : Executable class of the program
- [x] `Vertex.java` : Class that creates an instance of a vertex or node
- [x] `Edge.java` : Class that creates an edge between two vertices or nodes
- [x] `Graph.java` : Class that creates the template of the graph
- [x] `DataFileReader.java` : Class that handles data reading from external files
- [x] `GUI.java` : The frame of the GUI application
- [x] `MenuPanel.java` : Panel containing the different menu options of the application
- [x] `ContentPanel.java` : Main panel of the application, it is where most info are displayed
- [x] `GraphPanel.java` : Panel that displays the created graph
- [x] `HomepageContent.java` : Panel that is displayed first at runtime
- [x] `ImportPanel.java` : Panel that handles the importing of graph data
- [x] `BFSPanel.java` : Panel that involves the breadth first search traversal
- [x] `DFSPanel.java` : Panel that involves the depth first search traversal
- [x] `SPPanel.java` : Panel that involves the shortest path
- [x] `Graphics.java` : Class that sets the format of all components in the GUI application

