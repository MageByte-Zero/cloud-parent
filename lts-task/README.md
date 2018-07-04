JobTracker和LTS-Admin部署 提供(cmd)windows和(shell)linux两种版本脚本来进行编译和部署:

运行根目录下的sh build.sh或build.cmd脚本，会在dist目录下生成lts-{version}-bin文件夹

下面是其目录结构，其中bin目录主要是JobTracker和LTS-Admin的启动脚本。jobtracker 中是 JobTracker的配置文件和需要使用到的jar包，
lts-admin是LTS-Admin相关的war包和配置文件。 lts-{version}-bin的文件结构


JobTracker启动。如果你想启动一个节点，直接修改下conf/zoo下的配置文件，然后运行 sh jobtracker.sh zoo start即可，如果你想启动两个
JobTracker节点，那么你需要拷贝一份zoo,譬如命名为zoo2,修改下zoo2下的配置文件，然后运行sh jobtracker.sh zoo2 start即可。logs文件夹下生成jobtracker-zoo.out日志。
LTS-Admin启动.修改conf/lts-monitor.cfg和conf/lts-admin.cfg下的配置，然后运行bin下的sh lts-admin.sh或lts-admin.cmd脚本即可。
logs文件夹下会生成lts-admin.out日志，启动成功在日志中会打印出访问地址，用户可以通过这个访问地址访问了。

## 4. 部署建议

> * Admin后台: 建议Admin后台单独部署，默认会嵌入一个Monitor
> * Monitor：默认在Admin后台进程中有一个，如果一个不够，也可以单独启动多个
> * JobTracker: 建议单独部署
> * JobClient:,这个是提交任务的工程,一般是和业务相关的,所以会放在业 务工程中, 当然也要看业务场景
> * TaskTracker,这个因为是跑任务的,具体看业务场景, 一般情况下也可以是独立部署
