# 拼团营销系统（Group Buy Market）
## 项目概述
拼团营销系统是一个基于Java Spring Boot开发的电商拼团营销平台，支持商品拼团折扣、团队组建、订单管理和结算等功能。该系统采用DDD（领域驱动设计）架构，实现了拼团营销业务的核心流程。

## 系统架构
项目采用分层架构设计，遵循DDD（领域驱动设计）思想：

- API层 ：对外提供服务接口
- 应用层 ：协调各个领域服务
- 领域层 ：核心业务逻辑实现
- 基础设施层 ：提供技术支持，如数据库访问、缓存等
- 类型层 ：定义通用数据类型和枚举
### 项目模块
- group-buy-market-jun-api ：API接口定义
- group-buy-market-jun-app ：应用服务和配置
- group-buy-market-jun-domain ：领域模型和业务逻辑
- group-buy-market-jun-infrastructure ：基础设施实现
- group-buy-market-jun-trigger ：外部触发器（如HTTP接口）
- group-buy-market-jun-types ：通用类型定义
## 核心功能
### 1. 拼团活动管理
- 活动创建与配置
- 活动折扣规则设置
- 活动时间和目标管理
### 2. 商品营销
- 商品折扣计算
- 多种折扣策略支持（如满减MJ等）
- 商品价格试算
### 3. 拼团交易
- 拼团订单锁定
- 支付流程管理
- 订单结算处理
- 退款处理
### 4. 用户分组与标签
- 用户标签管理
- 人群标签批处理
- 基于标签的活动筛选
### 5. 系统配置
- 动态配置中心（DCC）
- 线程池配置
- Redis缓存管理
## 技术栈
- 核心框架 ：Spring Boot 2.7.12
- 数据库 ：MySQL 8.0
- 缓存 ：Redis (Redisson)
- 消息队列 ：RabbitMQ
- 构建工具 ：Maven
- 其他 ：
    - Guava Cache
    - Lombok
    - FastJSON
    - JWT认证
## 设计模式
系统中应用了多种设计模式：

- 策略模式 ：用于实现不同的折扣计算策略
- 责任链模式 ：用于处理交易流程中的各个环节
- 工厂模式 ：创建各种服务实例
- 聚合模式 ：DDD中的聚合根设计
## 部署说明
### 环境要求
- JDK 8+
- MySQL 8.0+
- Redis
- RabbitMQ
### 配置文件
项目包含多环境配置：

- application-dev.yml ：开发环境
- application-test.yml ：测试环境
- application-prod.yml ：生产环境
### Docker部署
项目支持Docker容器化部署，相关配置文件位于 docs/dev-ops 目录。

```
# 构建Docker镜像
./build.sh

# 使用docker-compose启动服务
docker-compose -f docker-compose-app.yml up 
-d
```
## 许可证
本项目采用Apache License 2.0许可证。详情请参阅LICENSE文件。