# Compile and run the test in the present directory: 
# It is assumed that JAF sources have been compiled and activation.jar formed. 
# Replace the jar location with the one you have elsewhere in case activation.jar 
# has been generated/downloaded by any other means.

# Compile
% javac -d  . -cp ../../../../../../build/solaris/activation.jar Bug6456395.java

# Run
% java  -cp ../../../../../../build/solaris/activation.jar:. demo.Bug6456395
Test Passed for String Object and Unknown MimeType
Test Passed for Byte array Object and Unknown MimeType

