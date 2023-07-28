# honagi-administrative

#### Swagger URL:</br>

[http://honagi.com/v2/api-docs](http://honagi.com/v2/api-docs)</br>
[http://honagi.com/swagger-ui/](http://honagi.com/swagger-ui/)

#### Logstash Config:</br>
Edit `logstash.conf`

```code
input {
  stdin {
  
  }
  tcp {
    port => 1704
  }
}

filter {
  json {
    source => "message"
  }
}

output {
  elasticsearch {
    hosts => ["http://localhost:9200"]
  }
  stdout {
    codec => rubydebug
  }
}
```

