# CS2334Project5

In order to tackle this project, the first thing I needed to know was how I wanted to draw the GUI for the program.
My goal was to get the extra credit points for creating extra windows, so I created 3 classes for the UI, plus a third for the creative window. The main window has all of the buttons as well as action listeners on it to check if something was clicked or changed.
the other classes show the hamming distance nodes, the creative idea, and the list of stations matching the selected distance on the slider.

Now that I had given myself a layout to start with, I had to figure out what components I would need and decide what all components that i would need for the layout. 

The action listeners were quite simple to set up, even for the ones with a new frame since it just is a constructor to a new frame.

Moving on to the logic, i knew i would have to get the data from a file, as well as calculate the hamming distance, so I created one class to read all of the stations from a file, as well as another class to calculate the hamming distances.

For the creative idea, I was lost, so I decided to make an animated number bouncing within a frame while changing size. That number is the hamming distance between two input numbers
