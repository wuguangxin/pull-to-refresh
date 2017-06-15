# pull-to-refresh
修改的 pull-to-refresh 框架

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.wuguangxin:pull-to-refresh:1.0.0'
	}
