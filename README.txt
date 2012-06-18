Noise-Tester
============

An extendable tool for testing noise-generation algorithms. Scalable visualizers for both one and two-dimensional noise are included, with quick-switching controls. Adding new noise functions is fairly easy, by inheriting from one of the included noise generators and overriding a single function. Basic noise generators are included, such as non-interpolated, linear-interpolated, and cosine-interpolated noise. A few more advanced noise generators are also included, such as one for Perlin Noise, and two noise generators of my own design. Both one and two-dimensional versions of each are included.

To test a new noise generation algorithm, create a new class, extending whatever NoiseMaker works best for your needs. Override the get method, and the constructor if needed. Use super.get as needed. Look at some of the included examples.

Once you have the class created, change NoiseTesterApplet and add a new NoiseMakerButton to the array of buttons, using an instance of your NoiseTester and any label you want.