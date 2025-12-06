
package model.response.userGrowth.CampaignLiveForProdUsers;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Params {

    @SerializedName("app.Campaign-CD-Splitter.spring.cloud.stream.kafka.binder.minPartitionCount")
    private String mAppCampaignCDSplitterSpringCloudStreamKafkaBinderMinPartitionCount;
    @SerializedName("app.Campaign-Cohort.spring.cloud.stream.kafka.binder.minPartitionCount")
    private String mAppCampaignCohortSpringCloudStreamKafkaBinderMinPartitionCount;
    @SerializedName("app.Campaign-Content-Discovery.spring.cloud.stream.kafka.binder.minPartitionCount")
    private String mAppCampaignContentDiscoverySpringCloudStreamKafkaBinderMinPartitionCount;
    @SerializedName("app.Campaign-Splitter.spring.cloud.stream.kafka.binder.minPartitionCount")
    private String mAppCampaignSplitterSpringCloudStreamKafkaBinderMinPartitionCount;
    @SerializedName("app.Campaign-Variant-Processor.spring.cloud.stream.kafka.binder.minPartitionCount")
    private String mAppCampaignVariantProcessorSpringCloudStreamKafkaBinderMinPartitionCount;
    @SerializedName("app.*.spring.cloud.stream.kafka.binder.brokers")
    private String mAppSpringCloudStreamKafkaBinderBrokers;
    @SerializedName("app.*.spring.cloud.stream.kafka.binder.configuration.auto.offset.reset")
    private String mAppSpringCloudStreamKafkaBinderConfigurationAutoOffsetReset;
    @SerializedName("app.*.spring.cloud.stream.kafka.binder.configuration.fetch.max.bytes")
    private String mAppSpringCloudStreamKafkaBinderConfigurationFetchMaxBytes;
    @SerializedName("app.*.spring.cloud.stream.kafka.binder.configuration.max.partition.fetch.bytes")
    private String mAppSpringCloudStreamKafkaBinderConfigurationMaxPartitionFetchBytes;
    @SerializedName("app.*.spring.cloud.stream.kafka.binder.configuration.max.request.size")
    private String mAppSpringCloudStreamKafkaBinderConfigurationMaxRequestSize;
    @SerializedName("app.*.spring.cloud.stream.kafka.binder.replication-factor")
    private String mAppSpringCloudStreamKafkaBinderReplicationFactor;
    @SerializedName("app.*.spring.cloud.stream.kafka.default.consumer.auto-commit-offset")
    private String mAppSpringCloudStreamKafkaDefaultConsumerAutoCommitOffset;
    @SerializedName("backfill")
    private String mBackfill;
    @SerializedName("bootstrap_servers")
    private String mBootstrapServers;
    @SerializedName("cluster_ip_gold")
    private String mClusterIpGold;
    @SerializedName("cluster_ip_platinum")
    private String mClusterIpPlatinum;
    @SerializedName("cluster_ip_spark3")
    private String mClusterIpSpark3;
    @SerializedName("deployer.Campaign-Aggregator.count")
    private String mDeployerCampaignAggregatorCount;
    @SerializedName("deployer.Campaign-Aggregator.kubernetes.limits.cpu")
    private String mDeployerCampaignAggregatorKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Aggregator.kubernetes.limits.memory")
    private String mDeployerCampaignAggregatorKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Aggregator.kubernetes.requests.cpu")
    private String mDeployerCampaignAggregatorKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Aggregator.kubernetes.requests.memory")
    private String mDeployerCampaignAggregatorKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-CD-Splitter.count")
    private String mDeployerCampaignCDSplitterCount;
    @SerializedName("deployer.Campaign-CD-Splitter.kubernetes.limits.cpu")
    private String mDeployerCampaignCDSplitterKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-CD-Splitter.kubernetes.limits.memory")
    private String mDeployerCampaignCDSplitterKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-CD-Splitter.kubernetes.requests.cpu")
    private String mDeployerCampaignCDSplitterKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-CD-Splitter.kubernetes.requests.memory")
    private String mDeployerCampaignCDSplitterKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-Cohort.kubernetes.limits.cpu")
    private String mDeployerCampaignCohortKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Cohort.kubernetes.limits.memory")
    private String mDeployerCampaignCohortKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Cohort.kubernetes.requests.cpu")
    private String mDeployerCampaignCohortKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Cohort.kubernetes.requests.memory")
    private String mDeployerCampaignCohortKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-Content-Discovery.count")
    private String mDeployerCampaignContentDiscoveryCount;
    @SerializedName("deployer.Campaign-Content-Discovery.kubernetes.limits.cpu")
    private String mDeployerCampaignContentDiscoveryKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Content-Discovery.kubernetes.limits.memory")
    private String mDeployerCampaignContentDiscoveryKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Content-Discovery.kubernetes.requests.cpu")
    private String mDeployerCampaignContentDiscoveryKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Content-Discovery.kubernetes.requests.memory")
    private String mDeployerCampaignContentDiscoveryKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-Count.kubernetes.limits.cpu")
    private String mDeployerCampaignCountKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Count.kubernetes.limits.memory")
    private String mDeployerCampaignCountKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Count.kubernetes.requests.cpu")
    private String mDeployerCampaignCountKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Count.kubernetes.requests.memory")
    private String mDeployerCampaignCountKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-Event.kubernetes.limits.cpu")
    private String mDeployerCampaignEventKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Event.kubernetes.limits.memory")
    private String mDeployerCampaignEventKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Event.kubernetes.requests.cpu")
    private String mDeployerCampaignEventKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Event.kubernetes.requests.memory")
    private String mDeployerCampaignEventKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-Message-Processor.count")
    private String mDeployerCampaignMessageProcessorCount;
    @SerializedName("deployer.Campaign-Message-Processor.kubernetes.limits.cpu")
    private String mDeployerCampaignMessageProcessorKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Message-Processor.kubernetes.limits.memory")
    private String mDeployerCampaignMessageProcessorKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Message-Processor.kubernetes.requests.cpu")
    private String mDeployerCampaignMessageProcessorKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Message-Processor.kubernetes.requests.memory")
    private String mDeployerCampaignMessageProcessorKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-Splitter.kubernetes.limits.cpu")
    private String mDeployerCampaignSplitterKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Splitter.kubernetes.limits.memory")
    private String mDeployerCampaignSplitterKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Splitter.kubernetes.requests.cpu")
    private String mDeployerCampaignSplitterKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Splitter.kubernetes.requests.memory")
    private String mDeployerCampaignSplitterKubernetesRequestsMemory;
    @SerializedName("deployer.Campaign-Variant-Processor.kubernetes.limits.cpu")
    private String mDeployerCampaignVariantProcessorKubernetesLimitsCpu;
    @SerializedName("deployer.Campaign-Variant-Processor.kubernetes.limits.memory")
    private String mDeployerCampaignVariantProcessorKubernetesLimitsMemory;
    @SerializedName("deployer.Campaign-Variant-Processor.kubernetes.requests.cpu")
    private String mDeployerCampaignVariantProcessorKubernetesRequestsCpu;
    @SerializedName("deployer.Campaign-Variant-Processor.kubernetes.requests.memory")
    private String mDeployerCampaignVariantProcessorKubernetesRequestsMemory;
    @SerializedName("deployer.log.kubernetes.limits.cpu")
    private String mDeployerLogKubernetesLimitsCpu;
    @SerializedName("deployer.log.kubernetes.limits.memory")
    private String mDeployerLogKubernetesLimitsMemory;
    @SerializedName("deployer.log.kubernetes.requests.cpu")
    private String mDeployerLogKubernetesRequestsCpu;
    @SerializedName("deployer.log.kubernetes.requests.memory")
    private String mDeployerLogKubernetesRequestsMemory;
    @SerializedName("env")
    private String mEnv;
    @SerializedName("flow_start_date")
    private Object mFlowStartDate;
    @SerializedName("kafka_jar_path")
    private String mKafkaJarPath;

    public String getAppCampaignCDSplitterSpringCloudStreamKafkaBinderMinPartitionCount() {
        return mAppCampaignCDSplitterSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public void setAppCampaignCDSplitterSpringCloudStreamKafkaBinderMinPartitionCount(String appCampaignCDSplitterSpringCloudStreamKafkaBinderMinPartitionCount) {
        mAppCampaignCDSplitterSpringCloudStreamKafkaBinderMinPartitionCount = appCampaignCDSplitterSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public String getAppCampaignCohortSpringCloudStreamKafkaBinderMinPartitionCount() {
        return mAppCampaignCohortSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public void setAppCampaignCohortSpringCloudStreamKafkaBinderMinPartitionCount(String appCampaignCohortSpringCloudStreamKafkaBinderMinPartitionCount) {
        mAppCampaignCohortSpringCloudStreamKafkaBinderMinPartitionCount = appCampaignCohortSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public String getAppCampaignContentDiscoverySpringCloudStreamKafkaBinderMinPartitionCount() {
        return mAppCampaignContentDiscoverySpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public void setAppCampaignContentDiscoverySpringCloudStreamKafkaBinderMinPartitionCount(String appCampaignContentDiscoverySpringCloudStreamKafkaBinderMinPartitionCount) {
        mAppCampaignContentDiscoverySpringCloudStreamKafkaBinderMinPartitionCount = appCampaignContentDiscoverySpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public String getAppCampaignSplitterSpringCloudStreamKafkaBinderMinPartitionCount() {
        return mAppCampaignSplitterSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public void setAppCampaignSplitterSpringCloudStreamKafkaBinderMinPartitionCount(String appCampaignSplitterSpringCloudStreamKafkaBinderMinPartitionCount) {
        mAppCampaignSplitterSpringCloudStreamKafkaBinderMinPartitionCount = appCampaignSplitterSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public String getAppCampaignVariantProcessorSpringCloudStreamKafkaBinderMinPartitionCount() {
        return mAppCampaignVariantProcessorSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public void setAppCampaignVariantProcessorSpringCloudStreamKafkaBinderMinPartitionCount(String appCampaignVariantProcessorSpringCloudStreamKafkaBinderMinPartitionCount) {
        mAppCampaignVariantProcessorSpringCloudStreamKafkaBinderMinPartitionCount = appCampaignVariantProcessorSpringCloudStreamKafkaBinderMinPartitionCount;
    }

    public String getAppSpringCloudStreamKafkaBinderBrokers() {
        return mAppSpringCloudStreamKafkaBinderBrokers;
    }

    public void setAppSpringCloudStreamKafkaBinderBrokers(String appSpringCloudStreamKafkaBinderBrokers) {
        mAppSpringCloudStreamKafkaBinderBrokers = appSpringCloudStreamKafkaBinderBrokers;
    }

    public String getAppSpringCloudStreamKafkaBinderConfigurationAutoOffsetReset() {
        return mAppSpringCloudStreamKafkaBinderConfigurationAutoOffsetReset;
    }

    public void setAppSpringCloudStreamKafkaBinderConfigurationAutoOffsetReset(String appSpringCloudStreamKafkaBinderConfigurationAutoOffsetReset) {
        mAppSpringCloudStreamKafkaBinderConfigurationAutoOffsetReset = appSpringCloudStreamKafkaBinderConfigurationAutoOffsetReset;
    }

    public String getAppSpringCloudStreamKafkaBinderConfigurationFetchMaxBytes() {
        return mAppSpringCloudStreamKafkaBinderConfigurationFetchMaxBytes;
    }

    public void setAppSpringCloudStreamKafkaBinderConfigurationFetchMaxBytes(String appSpringCloudStreamKafkaBinderConfigurationFetchMaxBytes) {
        mAppSpringCloudStreamKafkaBinderConfigurationFetchMaxBytes = appSpringCloudStreamKafkaBinderConfigurationFetchMaxBytes;
    }

    public String getAppSpringCloudStreamKafkaBinderConfigurationMaxPartitionFetchBytes() {
        return mAppSpringCloudStreamKafkaBinderConfigurationMaxPartitionFetchBytes;
    }

    public void setAppSpringCloudStreamKafkaBinderConfigurationMaxPartitionFetchBytes(String appSpringCloudStreamKafkaBinderConfigurationMaxPartitionFetchBytes) {
        mAppSpringCloudStreamKafkaBinderConfigurationMaxPartitionFetchBytes = appSpringCloudStreamKafkaBinderConfigurationMaxPartitionFetchBytes;
    }

    public String getAppSpringCloudStreamKafkaBinderConfigurationMaxRequestSize() {
        return mAppSpringCloudStreamKafkaBinderConfigurationMaxRequestSize;
    }

    public void setAppSpringCloudStreamKafkaBinderConfigurationMaxRequestSize(String appSpringCloudStreamKafkaBinderConfigurationMaxRequestSize) {
        mAppSpringCloudStreamKafkaBinderConfigurationMaxRequestSize = appSpringCloudStreamKafkaBinderConfigurationMaxRequestSize;
    }

    public String getAppSpringCloudStreamKafkaBinderReplicationFactor() {
        return mAppSpringCloudStreamKafkaBinderReplicationFactor;
    }

    public void setAppSpringCloudStreamKafkaBinderReplicationFactor(String appSpringCloudStreamKafkaBinderReplicationFactor) {
        mAppSpringCloudStreamKafkaBinderReplicationFactor = appSpringCloudStreamKafkaBinderReplicationFactor;
    }

    public String getAppSpringCloudStreamKafkaDefaultConsumerAutoCommitOffset() {
        return mAppSpringCloudStreamKafkaDefaultConsumerAutoCommitOffset;
    }

    public void setAppSpringCloudStreamKafkaDefaultConsumerAutoCommitOffset(String appSpringCloudStreamKafkaDefaultConsumerAutoCommitOffset) {
        mAppSpringCloudStreamKafkaDefaultConsumerAutoCommitOffset = appSpringCloudStreamKafkaDefaultConsumerAutoCommitOffset;
    }

    public String getBackfill() {
        return mBackfill;
    }

    public void setBackfill(String backfill) {
        mBackfill = backfill;
    }

    public String getBootstrapServers() {
        return mBootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        mBootstrapServers = bootstrapServers;
    }

    public String getClusterIpGold() {
        return mClusterIpGold;
    }

    public void setClusterIpGold(String clusterIpGold) {
        mClusterIpGold = clusterIpGold;
    }

    public String getClusterIpPlatinum() {
        return mClusterIpPlatinum;
    }

    public void setClusterIpPlatinum(String clusterIpPlatinum) {
        mClusterIpPlatinum = clusterIpPlatinum;
    }

    public String getClusterIpSpark3() {
        return mClusterIpSpark3;
    }

    public void setClusterIpSpark3(String clusterIpSpark3) {
        mClusterIpSpark3 = clusterIpSpark3;
    }

    public String getDeployerCampaignAggregatorCount() {
        return mDeployerCampaignAggregatorCount;
    }

    public void setDeployerCampaignAggregatorCount(String deployerCampaignAggregatorCount) {
        mDeployerCampaignAggregatorCount = deployerCampaignAggregatorCount;
    }

    public String getDeployerCampaignAggregatorKubernetesLimitsCpu() {
        return mDeployerCampaignAggregatorKubernetesLimitsCpu;
    }

    public void setDeployerCampaignAggregatorKubernetesLimitsCpu(String deployerCampaignAggregatorKubernetesLimitsCpu) {
        mDeployerCampaignAggregatorKubernetesLimitsCpu = deployerCampaignAggregatorKubernetesLimitsCpu;
    }

    public String getDeployerCampaignAggregatorKubernetesLimitsMemory() {
        return mDeployerCampaignAggregatorKubernetesLimitsMemory;
    }

    public void setDeployerCampaignAggregatorKubernetesLimitsMemory(String deployerCampaignAggregatorKubernetesLimitsMemory) {
        mDeployerCampaignAggregatorKubernetesLimitsMemory = deployerCampaignAggregatorKubernetesLimitsMemory;
    }

    public String getDeployerCampaignAggregatorKubernetesRequestsCpu() {
        return mDeployerCampaignAggregatorKubernetesRequestsCpu;
    }

    public void setDeployerCampaignAggregatorKubernetesRequestsCpu(String deployerCampaignAggregatorKubernetesRequestsCpu) {
        mDeployerCampaignAggregatorKubernetesRequestsCpu = deployerCampaignAggregatorKubernetesRequestsCpu;
    }

    public String getDeployerCampaignAggregatorKubernetesRequestsMemory() {
        return mDeployerCampaignAggregatorKubernetesRequestsMemory;
    }

    public void setDeployerCampaignAggregatorKubernetesRequestsMemory(String deployerCampaignAggregatorKubernetesRequestsMemory) {
        mDeployerCampaignAggregatorKubernetesRequestsMemory = deployerCampaignAggregatorKubernetesRequestsMemory;
    }

    public String getDeployerCampaignCDSplitterCount() {
        return mDeployerCampaignCDSplitterCount;
    }

    public void setDeployerCampaignCDSplitterCount(String deployerCampaignCDSplitterCount) {
        mDeployerCampaignCDSplitterCount = deployerCampaignCDSplitterCount;
    }

    public String getDeployerCampaignCDSplitterKubernetesLimitsCpu() {
        return mDeployerCampaignCDSplitterKubernetesLimitsCpu;
    }

    public void setDeployerCampaignCDSplitterKubernetesLimitsCpu(String deployerCampaignCDSplitterKubernetesLimitsCpu) {
        mDeployerCampaignCDSplitterKubernetesLimitsCpu = deployerCampaignCDSplitterKubernetesLimitsCpu;
    }

    public String getDeployerCampaignCDSplitterKubernetesLimitsMemory() {
        return mDeployerCampaignCDSplitterKubernetesLimitsMemory;
    }

    public void setDeployerCampaignCDSplitterKubernetesLimitsMemory(String deployerCampaignCDSplitterKubernetesLimitsMemory) {
        mDeployerCampaignCDSplitterKubernetesLimitsMemory = deployerCampaignCDSplitterKubernetesLimitsMemory;
    }

    public String getDeployerCampaignCDSplitterKubernetesRequestsCpu() {
        return mDeployerCampaignCDSplitterKubernetesRequestsCpu;
    }

    public void setDeployerCampaignCDSplitterKubernetesRequestsCpu(String deployerCampaignCDSplitterKubernetesRequestsCpu) {
        mDeployerCampaignCDSplitterKubernetesRequestsCpu = deployerCampaignCDSplitterKubernetesRequestsCpu;
    }

    public String getDeployerCampaignCDSplitterKubernetesRequestsMemory() {
        return mDeployerCampaignCDSplitterKubernetesRequestsMemory;
    }

    public void setDeployerCampaignCDSplitterKubernetesRequestsMemory(String deployerCampaignCDSplitterKubernetesRequestsMemory) {
        mDeployerCampaignCDSplitterKubernetesRequestsMemory = deployerCampaignCDSplitterKubernetesRequestsMemory;
    }

    public String getDeployerCampaignCohortKubernetesLimitsCpu() {
        return mDeployerCampaignCohortKubernetesLimitsCpu;
    }

    public void setDeployerCampaignCohortKubernetesLimitsCpu(String deployerCampaignCohortKubernetesLimitsCpu) {
        mDeployerCampaignCohortKubernetesLimitsCpu = deployerCampaignCohortKubernetesLimitsCpu;
    }

    public String getDeployerCampaignCohortKubernetesLimitsMemory() {
        return mDeployerCampaignCohortKubernetesLimitsMemory;
    }

    public void setDeployerCampaignCohortKubernetesLimitsMemory(String deployerCampaignCohortKubernetesLimitsMemory) {
        mDeployerCampaignCohortKubernetesLimitsMemory = deployerCampaignCohortKubernetesLimitsMemory;
    }

    public String getDeployerCampaignCohortKubernetesRequestsCpu() {
        return mDeployerCampaignCohortKubernetesRequestsCpu;
    }

    public void setDeployerCampaignCohortKubernetesRequestsCpu(String deployerCampaignCohortKubernetesRequestsCpu) {
        mDeployerCampaignCohortKubernetesRequestsCpu = deployerCampaignCohortKubernetesRequestsCpu;
    }

    public String getDeployerCampaignCohortKubernetesRequestsMemory() {
        return mDeployerCampaignCohortKubernetesRequestsMemory;
    }

    public void setDeployerCampaignCohortKubernetesRequestsMemory(String deployerCampaignCohortKubernetesRequestsMemory) {
        mDeployerCampaignCohortKubernetesRequestsMemory = deployerCampaignCohortKubernetesRequestsMemory;
    }

    public String getDeployerCampaignContentDiscoveryCount() {
        return mDeployerCampaignContentDiscoveryCount;
    }

    public void setDeployerCampaignContentDiscoveryCount(String deployerCampaignContentDiscoveryCount) {
        mDeployerCampaignContentDiscoveryCount = deployerCampaignContentDiscoveryCount;
    }

    public String getDeployerCampaignContentDiscoveryKubernetesLimitsCpu() {
        return mDeployerCampaignContentDiscoveryKubernetesLimitsCpu;
    }

    public void setDeployerCampaignContentDiscoveryKubernetesLimitsCpu(String deployerCampaignContentDiscoveryKubernetesLimitsCpu) {
        mDeployerCampaignContentDiscoveryKubernetesLimitsCpu = deployerCampaignContentDiscoveryKubernetesLimitsCpu;
    }

    public String getDeployerCampaignContentDiscoveryKubernetesLimitsMemory() {
        return mDeployerCampaignContentDiscoveryKubernetesLimitsMemory;
    }

    public void setDeployerCampaignContentDiscoveryKubernetesLimitsMemory(String deployerCampaignContentDiscoveryKubernetesLimitsMemory) {
        mDeployerCampaignContentDiscoveryKubernetesLimitsMemory = deployerCampaignContentDiscoveryKubernetesLimitsMemory;
    }

    public String getDeployerCampaignContentDiscoveryKubernetesRequestsCpu() {
        return mDeployerCampaignContentDiscoveryKubernetesRequestsCpu;
    }

    public void setDeployerCampaignContentDiscoveryKubernetesRequestsCpu(String deployerCampaignContentDiscoveryKubernetesRequestsCpu) {
        mDeployerCampaignContentDiscoveryKubernetesRequestsCpu = deployerCampaignContentDiscoveryKubernetesRequestsCpu;
    }

    public String getDeployerCampaignContentDiscoveryKubernetesRequestsMemory() {
        return mDeployerCampaignContentDiscoveryKubernetesRequestsMemory;
    }

    public void setDeployerCampaignContentDiscoveryKubernetesRequestsMemory(String deployerCampaignContentDiscoveryKubernetesRequestsMemory) {
        mDeployerCampaignContentDiscoveryKubernetesRequestsMemory = deployerCampaignContentDiscoveryKubernetesRequestsMemory;
    }

    public String getDeployerCampaignCountKubernetesLimitsCpu() {
        return mDeployerCampaignCountKubernetesLimitsCpu;
    }

    public void setDeployerCampaignCountKubernetesLimitsCpu(String deployerCampaignCountKubernetesLimitsCpu) {
        mDeployerCampaignCountKubernetesLimitsCpu = deployerCampaignCountKubernetesLimitsCpu;
    }

    public String getDeployerCampaignCountKubernetesLimitsMemory() {
        return mDeployerCampaignCountKubernetesLimitsMemory;
    }

    public void setDeployerCampaignCountKubernetesLimitsMemory(String deployerCampaignCountKubernetesLimitsMemory) {
        mDeployerCampaignCountKubernetesLimitsMemory = deployerCampaignCountKubernetesLimitsMemory;
    }

    public String getDeployerCampaignCountKubernetesRequestsCpu() {
        return mDeployerCampaignCountKubernetesRequestsCpu;
    }

    public void setDeployerCampaignCountKubernetesRequestsCpu(String deployerCampaignCountKubernetesRequestsCpu) {
        mDeployerCampaignCountKubernetesRequestsCpu = deployerCampaignCountKubernetesRequestsCpu;
    }

    public String getDeployerCampaignCountKubernetesRequestsMemory() {
        return mDeployerCampaignCountKubernetesRequestsMemory;
    }

    public void setDeployerCampaignCountKubernetesRequestsMemory(String deployerCampaignCountKubernetesRequestsMemory) {
        mDeployerCampaignCountKubernetesRequestsMemory = deployerCampaignCountKubernetesRequestsMemory;
    }

    public String getDeployerCampaignEventKubernetesLimitsCpu() {
        return mDeployerCampaignEventKubernetesLimitsCpu;
    }

    public void setDeployerCampaignEventKubernetesLimitsCpu(String deployerCampaignEventKubernetesLimitsCpu) {
        mDeployerCampaignEventKubernetesLimitsCpu = deployerCampaignEventKubernetesLimitsCpu;
    }

    public String getDeployerCampaignEventKubernetesLimitsMemory() {
        return mDeployerCampaignEventKubernetesLimitsMemory;
    }

    public void setDeployerCampaignEventKubernetesLimitsMemory(String deployerCampaignEventKubernetesLimitsMemory) {
        mDeployerCampaignEventKubernetesLimitsMemory = deployerCampaignEventKubernetesLimitsMemory;
    }

    public String getDeployerCampaignEventKubernetesRequestsCpu() {
        return mDeployerCampaignEventKubernetesRequestsCpu;
    }

    public void setDeployerCampaignEventKubernetesRequestsCpu(String deployerCampaignEventKubernetesRequestsCpu) {
        mDeployerCampaignEventKubernetesRequestsCpu = deployerCampaignEventKubernetesRequestsCpu;
    }

    public String getDeployerCampaignEventKubernetesRequestsMemory() {
        return mDeployerCampaignEventKubernetesRequestsMemory;
    }

    public void setDeployerCampaignEventKubernetesRequestsMemory(String deployerCampaignEventKubernetesRequestsMemory) {
        mDeployerCampaignEventKubernetesRequestsMemory = deployerCampaignEventKubernetesRequestsMemory;
    }

    public String getDeployerCampaignMessageProcessorCount() {
        return mDeployerCampaignMessageProcessorCount;
    }

    public void setDeployerCampaignMessageProcessorCount(String deployerCampaignMessageProcessorCount) {
        mDeployerCampaignMessageProcessorCount = deployerCampaignMessageProcessorCount;
    }

    public String getDeployerCampaignMessageProcessorKubernetesLimitsCpu() {
        return mDeployerCampaignMessageProcessorKubernetesLimitsCpu;
    }

    public void setDeployerCampaignMessageProcessorKubernetesLimitsCpu(String deployerCampaignMessageProcessorKubernetesLimitsCpu) {
        mDeployerCampaignMessageProcessorKubernetesLimitsCpu = deployerCampaignMessageProcessorKubernetesLimitsCpu;
    }

    public String getDeployerCampaignMessageProcessorKubernetesLimitsMemory() {
        return mDeployerCampaignMessageProcessorKubernetesLimitsMemory;
    }

    public void setDeployerCampaignMessageProcessorKubernetesLimitsMemory(String deployerCampaignMessageProcessorKubernetesLimitsMemory) {
        mDeployerCampaignMessageProcessorKubernetesLimitsMemory = deployerCampaignMessageProcessorKubernetesLimitsMemory;
    }

    public String getDeployerCampaignMessageProcessorKubernetesRequestsCpu() {
        return mDeployerCampaignMessageProcessorKubernetesRequestsCpu;
    }

    public void setDeployerCampaignMessageProcessorKubernetesRequestsCpu(String deployerCampaignMessageProcessorKubernetesRequestsCpu) {
        mDeployerCampaignMessageProcessorKubernetesRequestsCpu = deployerCampaignMessageProcessorKubernetesRequestsCpu;
    }

    public String getDeployerCampaignMessageProcessorKubernetesRequestsMemory() {
        return mDeployerCampaignMessageProcessorKubernetesRequestsMemory;
    }

    public void setDeployerCampaignMessageProcessorKubernetesRequestsMemory(String deployerCampaignMessageProcessorKubernetesRequestsMemory) {
        mDeployerCampaignMessageProcessorKubernetesRequestsMemory = deployerCampaignMessageProcessorKubernetesRequestsMemory;
    }

    public String getDeployerCampaignSplitterKubernetesLimitsCpu() {
        return mDeployerCampaignSplitterKubernetesLimitsCpu;
    }

    public void setDeployerCampaignSplitterKubernetesLimitsCpu(String deployerCampaignSplitterKubernetesLimitsCpu) {
        mDeployerCampaignSplitterKubernetesLimitsCpu = deployerCampaignSplitterKubernetesLimitsCpu;
    }

    public String getDeployerCampaignSplitterKubernetesLimitsMemory() {
        return mDeployerCampaignSplitterKubernetesLimitsMemory;
    }

    public void setDeployerCampaignSplitterKubernetesLimitsMemory(String deployerCampaignSplitterKubernetesLimitsMemory) {
        mDeployerCampaignSplitterKubernetesLimitsMemory = deployerCampaignSplitterKubernetesLimitsMemory;
    }

    public String getDeployerCampaignSplitterKubernetesRequestsCpu() {
        return mDeployerCampaignSplitterKubernetesRequestsCpu;
    }

    public void setDeployerCampaignSplitterKubernetesRequestsCpu(String deployerCampaignSplitterKubernetesRequestsCpu) {
        mDeployerCampaignSplitterKubernetesRequestsCpu = deployerCampaignSplitterKubernetesRequestsCpu;
    }

    public String getDeployerCampaignSplitterKubernetesRequestsMemory() {
        return mDeployerCampaignSplitterKubernetesRequestsMemory;
    }

    public void setDeployerCampaignSplitterKubernetesRequestsMemory(String deployerCampaignSplitterKubernetesRequestsMemory) {
        mDeployerCampaignSplitterKubernetesRequestsMemory = deployerCampaignSplitterKubernetesRequestsMemory;
    }

    public String getDeployerCampaignVariantProcessorKubernetesLimitsCpu() {
        return mDeployerCampaignVariantProcessorKubernetesLimitsCpu;
    }

    public void setDeployerCampaignVariantProcessorKubernetesLimitsCpu(String deployerCampaignVariantProcessorKubernetesLimitsCpu) {
        mDeployerCampaignVariantProcessorKubernetesLimitsCpu = deployerCampaignVariantProcessorKubernetesLimitsCpu;
    }

    public String getDeployerCampaignVariantProcessorKubernetesLimitsMemory() {
        return mDeployerCampaignVariantProcessorKubernetesLimitsMemory;
    }

    public void setDeployerCampaignVariantProcessorKubernetesLimitsMemory(String deployerCampaignVariantProcessorKubernetesLimitsMemory) {
        mDeployerCampaignVariantProcessorKubernetesLimitsMemory = deployerCampaignVariantProcessorKubernetesLimitsMemory;
    }

    public String getDeployerCampaignVariantProcessorKubernetesRequestsCpu() {
        return mDeployerCampaignVariantProcessorKubernetesRequestsCpu;
    }

    public void setDeployerCampaignVariantProcessorKubernetesRequestsCpu(String deployerCampaignVariantProcessorKubernetesRequestsCpu) {
        mDeployerCampaignVariantProcessorKubernetesRequestsCpu = deployerCampaignVariantProcessorKubernetesRequestsCpu;
    }

    public String getDeployerCampaignVariantProcessorKubernetesRequestsMemory() {
        return mDeployerCampaignVariantProcessorKubernetesRequestsMemory;
    }

    public void setDeployerCampaignVariantProcessorKubernetesRequestsMemory(String deployerCampaignVariantProcessorKubernetesRequestsMemory) {
        mDeployerCampaignVariantProcessorKubernetesRequestsMemory = deployerCampaignVariantProcessorKubernetesRequestsMemory;
    }

    public String getDeployerLogKubernetesLimitsCpu() {
        return mDeployerLogKubernetesLimitsCpu;
    }

    public void setDeployerLogKubernetesLimitsCpu(String deployerLogKubernetesLimitsCpu) {
        mDeployerLogKubernetesLimitsCpu = deployerLogKubernetesLimitsCpu;
    }

    public String getDeployerLogKubernetesLimitsMemory() {
        return mDeployerLogKubernetesLimitsMemory;
    }

    public void setDeployerLogKubernetesLimitsMemory(String deployerLogKubernetesLimitsMemory) {
        mDeployerLogKubernetesLimitsMemory = deployerLogKubernetesLimitsMemory;
    }

    public String getDeployerLogKubernetesRequestsCpu() {
        return mDeployerLogKubernetesRequestsCpu;
    }

    public void setDeployerLogKubernetesRequestsCpu(String deployerLogKubernetesRequestsCpu) {
        mDeployerLogKubernetesRequestsCpu = deployerLogKubernetesRequestsCpu;
    }

    public String getDeployerLogKubernetesRequestsMemory() {
        return mDeployerLogKubernetesRequestsMemory;
    }

    public void setDeployerLogKubernetesRequestsMemory(String deployerLogKubernetesRequestsMemory) {
        mDeployerLogKubernetesRequestsMemory = deployerLogKubernetesRequestsMemory;
    }

    public String getEnv() {
        return mEnv;
    }

    public void setEnv(String env) {
        mEnv = env;
    }

    public Object getFlowStartDate() {
        return mFlowStartDate;
    }

    public void setFlowStartDate(Object flowStartDate) {
        mFlowStartDate = flowStartDate;
    }

    public String getKafkaJarPath() {
        return mKafkaJarPath;
    }

    public void setKafkaJarPath(String kafkaJarPath) {
        mKafkaJarPath = kafkaJarPath;
    }

}
