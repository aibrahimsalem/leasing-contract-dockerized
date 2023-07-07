FROM gradle:7.6.2-jdk17-focal

WORKDIR /leasing-contract
COPY . .
RUN gradle build

CMD gradle bootRun