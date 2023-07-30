# Project Structure
 - ELK folder contains ELK files

# Logstash
 - we need to set the port for input to the actual port on which logstash is running inside the container.

### ES_JAVA_OPT=-"Xms512m -Xmx512m"
 - This environment variable in Docker Compose is used to set the Java heap size for Elasticsearch. The 
  -Xms and -Xmx options specify the minimum and maximum heap sizes in megabytes, respectively.

### How can we know the memory usage for each docker container
 - Use the docker stats command.