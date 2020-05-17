# 1. Restful
```bash
# Download the TensorFlow Serving Docker image and repo
docker pull tensorflow/serving

git clone https://github.com/tensorflow/serving
# Location of demo models
TESTDATA="$(pwd)/serving/tensorflow_serving/servables/tensorflow/testdata"

# Start TensorFlow Serving container and open the REST API port
docker run -t --rm -p 8501:8501 \
    -v "$TESTDATA/saved_model_half_plus_two_cpu:/models/half_plus_two" \
    -e MODEL_NAME=half_plus_two \
    tensorflow/serving &

# Query the model using the predict API
curl -d '{"instances": [1.0, 2.0, 5.0]}' \
    -X POST http://localhost:8501/v1/models/half_plus_two:predict

# Returns => { "predictions": [2.5, 3.0, 4.5] }
```
# 2. Rpc

## 2.1 下载Tensorflow工程

```bash
export SRC=~/Documents/source_code/
mkdir -p $SRC

cd $SRC
git clone git@github.com:tensorflow/serving.git
cd serving
# 选择一个tag
git checkout tags/2.1.0

# another repo
cd $SRC
git clone git@github.com:tensorflow/tensorflow.git
cd tensorflow
# 选择一个tag，要和serving的版本相同
git checkout tags/v2.1.0
```

## 2.2 将proto文件拷贝到Java工程

```bash
export PROJECT_ROOT=$SRC/tensorflow-serve-client
mkdir -p $PROJECT_ROOT/src/main/proto/
rsync -arv  --prune-empty-dirs --include="*/" --include='*.proto' --exclude='*' $SRC/serving/tensorflow_serving  $PROJECT_ROOT/src/main/proto/
rsync -arv  --prune-empty-dirs --include="*/" --include="tensorflow/core/lib/core/*.proto" --include='tensorflow/core/framework/*.proto' --include="tensorflow/core/example/*.proto" --include="tensorflow/core/protobuf/*.proto" --exclude='*' $SRC/tensorflow/tensorflow  $PROJECT_ROOT/src/main/proto/
```

## 2.3 maven依赖
```xml
<properties>
    <grpc.version>1.20.0</grpc.version>
</properties>

<dependencies>
    <dependency>
        <groupId>com.google.protobuf</groupId>
        <artifactId>protobuf-java</artifactId>
        <version>3.12.0</version>
    </dependency>
    <dependency>
      <groupId>com.google.protobuf</groupId>
      <artifactId>protobuf-java-util</artifactId>
      <!--版本和安装的protocal compiler（protoc）版本相同-->
      <version>3.12.0</version>
    </dependency>
    <!-- gRPC protobuf client -->
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-protobuf</artifactId>
        <version>1.28.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-stub</artifactId>
        <version>1.28.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-netty-shaded</artifactId>
        <version>1.28.0</version>
    </dependency>
</dependencies>
```

## 2.4 安装protobuf编译器protoc

[protobuf（protoc）安装](https://github.com/protocolbuffers/protobuf/tree/master/java)

1. [安装protoc](https://github.com/protocolbuffers/protobuf/blob/master/README.md)

将[protoc的执行文件](https://github.com/protocolbuffers/protobuf/releases)拷贝到`/usr/local/bin/protoc/`

2. 使用maven

注意和protoc版本对应

## 2.5 编辑proto文件和编译
proto文件存放在工程的main文件夹下，

```bash
mvn protobuf:compile
```

java文件会生成到target中