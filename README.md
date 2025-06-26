# ELK stack-logging-example
How to perform centralize logging in microservice architecture using ELK Stack

Download ELK Binary Distrubution

1.Elastic Search https://www.elastic.co/downloads/elasticsearch

2.Logstash https://www.elastic.co/downloads/logstash

3.Kibana https://www.elastic.co/downloads/kibana

# elasticsearch-9.0.2

C:\Users\gkish\Softwares\elasticsearch-9.0.2\config\elasticsearch.yml

update in elasticsearch.yml

cluster.name: my-application

path.data: C:\Users\gkish\Workspace\spring-boot-elasticsearch-example

save them

# Run commandline 

elasticsearch-9.0.2\bin>elasticsearch.bat

# kibana-9.0.2

Go to kibana-9.0.2\config.yml file

Update :elasticsearch.hosts: ["http://localhost:9200"]

# Run commandline 

kibana-9.0.2\bin>kibana.bat

Created logstash.conf
```
input {
  file {
    path => "C:/Users/gkish/Desktop/elkLogs/elk-stack.log"
    start_position => "beginning"
  }
}

output {
  stdout {
    codec => rubydebug
  }

  elasticsearch {
    hosts => ["http://localhost:9200"]
  }
}

```
Run 

>logstash -f logstash.conf


logstash-9.0.2\bin>logstash -f logstash.conf
