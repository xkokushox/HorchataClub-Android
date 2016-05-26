/**
 *
 */
package com.freakybyte.horchataclub.controller.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freakybyte.horchataclub.R;
import com.freakybyte.horchataclub.listener.RecyclerListListener;
import com.freakybyte.horchataclub.model.DishModel;
import com.freakybyte.horchataclub.view.holder.DishViewHolder;

import java.util.ArrayList;

/**
 * @author José Torres Fuentes
 */

public class AllDishListAdapter extends RecyclerView.Adapter<DishViewHolder> {

    public static final String TAG = "AllDishListAdapter";
    public ArrayList<DishModel> aListDishes = new ArrayList<>();
    private Activity mActivity;
    private RecyclerListListener mClickListener;

    /**
     * @param context
     */
    public AllDishListAdapter(Activity context, RecyclerListListener mClickListener) {
        this.mActivity = context;
        this.mClickListener = mClickListener;
    }

    @Override
    public DishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_dish, parent, false);
        DishViewHolder vh = new DishViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DishViewHolder viewHolder, final int position) {
        final DishModel mDish = aListDishes.get(position);

        viewHolder.getTxtDishTitle().setText(mDish.name);
        viewHolder.getTxtDishSmall().setText(mDish.small_text);
        viewHolder.getTxtDishAddress().setText(mDish.address);

        Uri uri = Uri.parse(mDish.image);
        viewHolder.getImgDish().setImageURI(uri);

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null)
                    mClickListener.OnItemClickListener(position);
            }
        });

        switch ((int) mDish.grade) {
            case 1:
                viewHolder.getImgStar1().setVisibility(View.VISIBLE);
                viewHolder.getImgStar2().setVisibility(View.GONE);
                viewHolder.getImgStar3().setVisibility(View.GONE);
                viewHolder.getImgStar4().setVisibility(View.GONE);
                viewHolder.getImgStar5().setVisibility(View.GONE);
                break;
            case 2:
                viewHolder.getImgStar1().setVisibility(View.VISIBLE);
                viewHolder.getImgStar2().setVisibility(View.VISIBLE);
                viewHolder.getImgStar3().setVisibility(View.GONE);
                viewHolder.getImgStar4().setVisibility(View.GONE);
                viewHolder.getImgStar5().setVisibility(View.GONE);
                break;
            case 3:

                viewHolder.getImgStar1().setVisibility(View.VISIBLE);
                viewHolder.getImgStar2().setVisibility(View.VISIBLE);
                viewHolder.getImgStar3().setVisibility(View.VISIBLE);
                viewHolder.getImgStar4().setVisibility(View.GONE);
                viewHolder.getImgStar5().setVisibility(View.GONE);
                break;
            case 4:
                viewHolder.getImgStar1().setVisibility(View.VISIBLE);
                viewHolder.getImgStar2().setVisibility(View.VISIBLE);
                viewHolder.getImgStar3().setVisibility(View.VISIBLE);
                viewHolder.getImgStar4().setVisibility(View.VISIBLE);
                viewHolder.getImgStar5().setVisibility(View.GONE);
                break;
            case 5:
                viewHolder.getImgStar1().setVisibility(View.VISIBLE);
                viewHolder.getImgStar2().setVisibility(View.VISIBLE);
                viewHolder.getImgStar3().setVisibility(View.VISIBLE);
                viewHolder.getImgStar4().setVisibility(View.VISIBLE);
                viewHolder.getImgStar5().setVisibility(View.VISIBLE);
                break;
            default:
                viewHolder.getImgStar1().setVisibility(View.GONE);
                viewHolder.getImgStar2().setVisibility(View.GONE);
                viewHolder.getImgStar3().setVisibility(View.GONE);
                viewHolder.getImgStar4().setVisibility(View.GONE);
                viewHolder.getImgStar5().setVisibility(View.GONE);
                break;
        }

    }


    @Override
    public int getItemCount() {
        return aListDishes.size();
    }

    public void setListDishes(ArrayList<DishModel> aListDishes) {
        this.aListDishes.clear();
        this.aListDishes = aListDishes;
        notifyDataSetChanged();
    }

}
