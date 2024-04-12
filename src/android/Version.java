package org.apache.cordova.appupdate;

/**
 * Created by LuoWen on 2015/12/14.
 */
public class Version {
    /**
   * Peter, 20240412: 0 可选更新, 1 强制更新
   */
  private int force;
  /**
   * 本地版本号
   */
  private int localCode;
  /**
   * 服务器版本号
   */
  private int remoteCode;
  /**
   * 服务器版本名称
   */
  private String remoteName;
  /**
   * 更新内容
   */
  private String remoteRemark;


  public Version(int force, int localCode, int remoteCode, String remoteName, String remoteRemark) {
    this.force = force;// Peter, 20240412: 0 可选更新, 1 强制更新
    this.localCode = localCode;
    this.remoteCode = remoteCode;
    this.remoteName = remoteName;
    this.remoteRemark = remoteRemark;
  }

  // Peter, 20240412: 0 可选更新, 1 强制更新
  public int getForce() {
    return force;
  }

  public int getLocalCode() {
    return localCode;
  }

  public int getRemoteCode() {
    return remoteCode;
  }

  public String getRemoteName() {
    return remoteName;
  }

  public String getRemoteRemark() {
    return remoteRemark;
  }
}