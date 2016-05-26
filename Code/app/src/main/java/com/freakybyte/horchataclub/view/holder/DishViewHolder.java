package com.freakybyte.horchataclub.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.freakybyte.horchataclub.R;
import com.freakybyte.horchataclub.view.AutoFitTxtView;

/**
 * Created by kokusho on 2/29/16.
 */
public class DishViewHolder extends RecyclerView.ViewHolder {
    public View view = null;
    private SimpleDraweeView img_item_dish = null;
    private AutoFitTxtView txt_item_dish_title = null;
    private AutoFitTxtView txt_item_dish_small = null;
    private AutoFitTxtView txt_item_dish_address = null;
    private ImageView img_star_1 = null;
    private ImageView img_star_2 = null;
    private ImageView img_star_3 = null;
    private ImageView img_star_4 = null;
    private ImageView img_star_5 = null;

    public DishViewHolder(View base) {
        super(base);
        this.view = base;
    }


    public SimpleDraweeView getImgDish() {
        if (img_item_dish == null)
            img_item_dish = (SimpleDraweeView) view.findViewById(R.id.img_item_dish);
        return img_item_dish;
    }

    public AutoFitTxtView getTxtDishTitle() {
        if (txt_item_dish_title == null)
            txt_item_dish_title = (AutoFitTxtView) view.findViewById(R.id.txt_item_dish_title);
        return txt_item_dish_title;
    }

    public AutoFitTxtView getTxtDishSmall() {
        if (txt_item_dish_small == null)
            txt_item_dish_small = (AutoFitTxtView) view.findViewById(R.id.txt_item_dish_small);
        return txt_item_dish_small;
    }

    public AutoFitTxtView getTxtDishAddress() {
        if (txt_item_dish_address == null)
            txt_item_dish_address = (AutoFitTxtView) view.findViewById(R.id.txt_item_dish_address);
        return txt_item_dish_address;
    }

    public ImageView getImgStar1() {
        if (img_star_1 == null)
            img_star_1 = (ImageView) view.findViewById(R.id.img_star_1);
        return img_star_1;
    }

    public ImageView getImgStar2() {
        if (img_star_2 == null)
            img_star_2 = (ImageView) view.findViewById(R.id.img_star_2);
        return img_star_2;
    }

    public ImageView getImgStar4() {
        if (img_star_4 == null)
            img_star_4 = (ImageView) view.findViewById(R.id.img_star_4);
        return img_star_4;
    }

    public ImageView getImgStar3() {
        if (img_star_3 == null)
            img_star_3 = (ImageView) view.findViewById(R.id.img_star_3);
        return img_star_3;
    }

    public ImageView getImgStar5() {
        if (img_star_5 == null)
            img_star_5 = (ImageView) view.findViewById(R.id.img_star_5);
        return img_star_5;
    }

}
