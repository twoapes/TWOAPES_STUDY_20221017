# 如何安装MongoDB

[Install MongoDB Enterprise Edition on Red Hat or CentOS — MongoDB Manual](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-enterprise-on-red-hat/)

```sh
vim /etc/yum.repos.d/mongodb-org-6.0.repo


[mongodb-org-6.0]
name=MongoDB Repository
baseurl=https://repo.mongodb.org/yum/redhat/$releasever/mongodb-org/6.0/x86_64/
gpgcheck=1
enabled=1
gpgkey=https://www.mongodb.org/static/pgp/server-6.0.asc


yum install -y mongodb-org

yum install -y mongodb-org-6.0.4 mongodb-org-database-6.0.4 mongodb-org-server-6.0.4 mongodb-org-mongos-6.0.4 mongodb-org-tools-6.0.4

#防止版本升级
vim /etc/yum.conf
exclude=mongodb-org,mongodb-org-database,mongodb-org-server,mongodb-mongosh,mongodb-org-mongos,mongodb-org-tools

/var/lib/mongo (the data directory)
/var/log/mongodb (the log directory)

systemctl enable mongod
show dbs
```

```sh
db.createUser({user: "twoapes",pwd: "QQqq1234.",roles: [ { role: "root", db: "admin" } ]})

db.auth("twoapes","QQqq1234.");

#db.system.users.remove({user:"twoapes"})

/etc/mongo.conf

db.vocabulary.insert({"name" : "test","value":"测试"})
```
