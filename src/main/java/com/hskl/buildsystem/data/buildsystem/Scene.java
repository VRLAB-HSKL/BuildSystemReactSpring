package com.hskl.buildsystem.data.buildsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * MongoDB: contains all scene data
 */
public class Scene {

    // scene name
    private String sceneName;

    // list of unity assets
    private List<Asset> unityAssets;

    // buildplatform
    String selectedBuildPlatform;

    /**
     * ctor
     */
    public Scene() {
        this.unityAssets = new ArrayList<Asset>();
    }

    /**
     * ctor with params
     * @param sceneName - scene name
     * @param assetList - asset list
     * @param buildPlatformatform - buildplatform
     */
    public Scene(String sceneName, List<Asset> assetList, String buildPlatformatform) {
        this.sceneName = sceneName;
        this.unityAssets = assetList;
        this.selectedBuildPlatform = buildPlatformatform;
    }

    /**
     * getter scene name
     * @return scene name
     */
    public String getSceneName() {
        return sceneName;
    }

    /**
     * setter scene name
     * @param sceneName - scene name
     */
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    /**
     * add assets
     * @param asset - asset
     */
    public void addAsset(Asset asset) {
        unityAssets.add(asset);
    }

    /**
     * Getter List of Assets
     * @return a list with all assets
     */
    public List<Asset> getUnityAssets() {
        return unityAssets;
    }

    /**
     * Setter list of assets
     * @param unityAssets
     */
    public void setUnityAssets(List<Asset> unityAssets) {
        this.unityAssets = unityAssets;
    }

    /**
     * Getter buildplatform
     * @return the scene buildplatform
     */
    public String getSelectedBuildPlatform() {
        return selectedBuildPlatform;
    }

    /**
     * Setter buildplatform
     * @param selectedBuildPlatform - selected buildplatform
     */
    public void setSelectedBuildPlatform(String selectedBuildPlatform) {
        this.selectedBuildPlatform = selectedBuildPlatform;
    }
}
