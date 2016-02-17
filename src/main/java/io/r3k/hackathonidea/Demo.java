package io.r3k.hackathonidea;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.debug.WireBox;
import com.jme3.scene.shape.Sphere;


public class Demo extends SimpleApplication {

    Geometry sphere1;
    
    public static void main(String[] args) {
        Demo app = new Demo();
        app.setShowSettings(false);
        app.start();
    }

    public Geometry attachWireBox(Vector3f pos, float size, ColorRGBA color) {
        Geometry g = new Geometry("wireframe cube", new WireBox(size, size, size));
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setWireframe(true);
        mat.setColor("Color", color);
        g.setMaterial(mat);
        g.setLocalTranslation(pos);
        rootNode.attachChild(g);
        return g;
    }

    @Override
    public void simpleInitApp() {
        rootNode.attachChild(attachWireBox(new Vector3f(0, 0, 0), 4, ColorRGBA.Red));
        sphere1 = sphere(0f, 0f, 0f,0.3f,ColorRGBA.Blue);
    }

    @Override
    public void simpleUpdate(float tpf) {
        Vector3f currentPos = sphere1.getLocalTranslation();
        if (currentPos.getX() < 2){
            currentPos.setX(currentPos.getX()+0.001f);
        }
        else {
            currentPos.setX(0f);
        }
        sphere1.setLocalTranslation(currentPos);
    }

    private Geometry sphere(float x, float y, float z, float size,ColorRGBA color) {
        Material m1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        m1.setColor("Color", color);
        Sphere q1 = new Sphere(50, 50, size);
        //Torus t = new Torus(8, 8, 0.03f, 0.04f);
        Geometry g1 = new Geometry("g1", q1);
        g1.setMaterial(m1);
        g1.setLocalTranslation(x, y, z);
        rootNode.attachChild(g1);
        return g1;
    }
}
