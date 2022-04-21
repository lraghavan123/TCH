# Steps to execute the solution in command line
### JDK Set up
 - Download JDK 8 from here: https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
 - Go to System Settings >> Advanced >> Environment Variables option. Choose 'Edit' on 'PATH' variable. Add jdk's bin folder path here.
 - Open command prompt, run command ```java -version```.  Java's installed version will be displayed.
### Git Set up
- Download Git for windows from here: https://git-scm.com/downloads
- Run the exe file in local system.
- Open windows explorer. Right click inside any folder.  Context menu must show "Git Bash here" option.
### Run below commands to execute solution from GitHub
- Open Windows Explorer.  Create a folder git_test.
- Open git bash inside git_test. 
- Run command: ```git clone https://github.com/lraghavan123/TCH.git```
- Open Command window.  Go to location \git_test\TCH
- Run command: ```java solution.Search```
- To do searches multiple times, repeat command: ```java solution.Search```
# Design Notes
- Solution can be extended to execute multiple searches with a "Do you wish to continue?" option
- Enums can be used for search types
- Instead of loading the file from github repo, option could be given to the user to choose the file to upload.
- Validations could be added to check file not found, corrupt data, wrong format.
# Unit, Integration Testing Strategies
- JUnit tests could include testing valid, invalid input and no input for search type and search value
- Loading the file feature can be tested with corrupt file, incorrect syntax and no file available.
- Testing the search feature alone can be done by adding mock bank data. Mockito framework could be used.
