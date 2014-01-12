includeTargets << grailsScript("_GrailsBootstrap")

includeTargets << new File(assetPipelinePluginDir, "scripts/_AssetCompile.groovy")

target(assetPrecompile: "Precompiles assets in the application as specified by the precompile glob!") {
  depends(configureProxy,compile, packageApp)
	def assetHelper             = classLoader.loadClass('asset.pipeline.AssetHelper')
  def directiveProcessorClass = classLoader.loadClass('asset.pipeline.DirectiveProcessor')
  def coffeeAssetFileClass = classLoader.loadClass('asset.pipeline.coffee.CoffeeAssetFile')

  def turbolinksFile = coffeeAssetFileClass.newInstance(new File('grails-app/assets/javascripts/turbolinks.js.coffee'))
  def generatedJs = turbolinksFile.processedStream(true)

  def outputFile = new File("web-app/js/turbolinks.js")
  outputFile.createNewFile()
  outputFile.text = generatedJs

}

setDefaultTarget(assetPrecompile)
