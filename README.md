# Images-to-Pdf-java


A simple java utility program to convert all your images into a single pdf file using pdfbox library.

It works in two modes[set shuffle to false or true]
1. If true - this mode will pick any files from the specified folder and index them based on their names
2. If false - it will create the pdf file from the source folder by order, you need to name your files as 1.jpeg,2.jpeg and so on.

It take the following paramters:-

1.String folderPath - path of the folder where your images are
2.String destFileName - the output file name without .pdf extension
3.boolean shufflingImages - Mode
4.String imageExtension - extension of your images eg:- ".jpeg"
